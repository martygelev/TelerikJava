package exe.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloJava {
    @GetMapping("/hello")
    public static String hello(){
        return "Hello, Spring";
    }
}
