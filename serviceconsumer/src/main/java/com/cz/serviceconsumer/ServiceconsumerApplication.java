package com.cz.serviceconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class ServiceconsumerApplication {

    /*@Autowired
    private RestTemplateBuilder builder;

    @Bean
    public RestTemplate restTemplate() {
        return builder.build();
    }*/

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/")
    String home() {
        return "hello world!";
    }

    @RequestMapping("/registered")
    public String getRegistered(){
        List<ServiceInstance> list = discoveryClient.getInstances("STORES");
//        System.out.println(discoveryClient.getLocalServiceInstance());
        System.out.println("discoveryClient.getServices().size() = " + discoveryClient.getServices().size());

        for( String s :  discoveryClient.getServices()){
            System.out.println("services " + s);
            List<ServiceInstance> serviceInstances =  discoveryClient.getInstances(s);
            for(ServiceInstance si : serviceInstances){
                System.out.println("    services:" + s + ":getHost()=" + si.getHost());
                System.out.println("    services:" + s + ":getPort()=" + si.getPort());
                System.out.println("    services:" + s + ":getServiceId()=" + si.getServiceId());
                System.out.println("    services:" + s + ":getUri()=" + si.getUri());
                System.out.println("    services:" + s + ":getMetadata()=" + si.getMetadata());
            }

        }

        System.out.println(list.size());
        if (list != null && list.size() > 0 ) {
            System.out.println( list.get(0).getUri()  );
        }
        return null;
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceconsumerApplication.class, args);
    }
}
