package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    
    @GetMapping("/demo")
    @ResponseBody
    public String index() {
        return "왜 내 spring boot devtool은 서버 재시작을 해줘야 하는가...";
    }
    
}
