package io.javabrains.springbootstarter.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello") // by default RequestMapping maps the http method to GET
    public String sayHi(){
        return "Hi";
    }
}
