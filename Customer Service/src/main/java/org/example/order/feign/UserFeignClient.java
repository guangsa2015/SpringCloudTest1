package org.example.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

//指定要调用的服务名称（与user-service的spring.application.name一致）
@FeignClient(name = "user-service")
public interface UserFeignClient {

    // 与服务提供者user-service中UserController的接口定义一致, 完整的请求地址
    @GetMapping("/users/{id}")
    Map<String, String> getUsers(@PathVariable("id") long id);
}
