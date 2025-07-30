package org.example.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "factory-service")
public interface FactoryFeignClient {

    @GetMapping("/factory/{name}")
    public String create(@PathVariable("name") String name);
}
