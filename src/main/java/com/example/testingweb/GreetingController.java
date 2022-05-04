package com.example.testingweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class GreetingController {

    private final GreetingService service;

    public GreetingController(GreetingService service) {
        this.service = service;
    }

    @RequestMapping("/greeting")
    public @ResponseBody String greeting() {
        return service.greet();
    }

    @RequestMapping("/get")
    public @ResponseBody String get(GetModel getModel) {
        //log.info("get 요청 데이터 = {}", getModel);
        System.out.println("get 요청 데이터 == " + getModel);

        return service.getCalled();
    }

}