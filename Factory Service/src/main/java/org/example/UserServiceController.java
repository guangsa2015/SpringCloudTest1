package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserServiceController {

    @GetMapping("/{id}")
    public Map<String, String> getUsers(@PathVariable("id") long id) {

        Map<String, String> users = new HashMap<>();
        users.put("id", String.valueOf(id));
        users.put("name", "姓"+String.valueOf(id));
        users.put("server", "factory");
        return users;
    }
}
