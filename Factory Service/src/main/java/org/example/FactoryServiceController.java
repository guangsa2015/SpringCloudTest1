package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/factory")
public class FactoryServiceController {

     @GetMapping("/{name}")
     public String create(@PathVariable("name") String name){
         return "生成新名字=>"+name;
     }

}
