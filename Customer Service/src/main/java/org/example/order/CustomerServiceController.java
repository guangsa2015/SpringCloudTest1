package org.example.order;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.order.feign.FactoryFeignClient;
import org.example.order.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class CustomerServiceController {

    @Autowired
    //@Qualifier("user-service")
    private UserFeignClient feignClient;

    //熔断机制resilience4j ,超时后自动本地降级处理
    @CircuitBreaker(name = "userService", fallbackMethod = "getOrderFallback")
    @GetMapping("/feign/order/{id}")
    public Map<String,String> getOrder(@PathVariable("id") long id){
        //Feign调用已经默认实现了负载均衡
       System.out.println("通过Feign远程调用[user service getOrder]...");
       return feignClient.getUsers(id);
    }

    @Autowired
    private FactoryFeignClient factoryFeignClient;

    @GetMapping("/info")
    public String getInfo(){
        return "order service info";
    }

    @CircuitBreaker(name = "userService",fallbackMethod ="getFactoryFallback" )
    @GetMapping("/factory/{name}")
    public String factory(@PathVariable("name") String name){
        System.out.println("通过Feign远程调用[factory service create]...");
        String nn = factoryFeignClient.create(name);
        return nn;
    }

    /**
     * 熔断降级处理
     * @param id
     * @return
     */
    public Map<String,String> getOrderFallback(long id, Exception ex){
        System.out.println("Feign远程调用失败-user，降级处理...");
        HashMap<String, String> map = new HashMap<>();
        map.put("id", "");
        map.put("name", "");
        map.put("server", "error 降级");
        return map;
    }
    /**
     * 熔断降级处理
     * @return
     */
    public String getFactoryFallback(Exception ex){
        System.out.println("Feign远程调用失败-factory，降级处理...");

        return "响应超时，请稍候再试";
    }

}
