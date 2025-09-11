package com.hansreidan.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Value("spring.application.name")
    private String homeName;

    @RequestMapping("/")
    public String index(){
        System.out.println(homeName);
        return "index.html";
    }
}
