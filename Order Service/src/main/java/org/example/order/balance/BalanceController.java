package org.example.order.balance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


//Feign调用已经默认实现了负载均衡
@RestController
@RequestMapping("/balance")
public class BalanceController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public String  callProvider(){
        String url = "http://user-service/users/13";
        return  restTemplate.getForObject(url, String.class);
    }
}
