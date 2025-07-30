package org.example.order.balance;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class BalanceRestConfig {

    @Bean
    //启用负载均衡  //Feign调用已经默认实现了负载均衡
    @LoadBalanced
    public RestTemplate restTemplate() {
      return new RestTemplate();
    }
}
