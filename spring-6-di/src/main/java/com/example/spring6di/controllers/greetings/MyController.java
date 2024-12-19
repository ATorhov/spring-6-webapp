package com.example.spring6di.controllers.greetings;

import com.example.spring6di.services.greetings.GreetingService;
import com.example.spring6di.services.greetings.GreetingServiceImpl;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    private final GreetingService greetingService;


    // Dependency without injection - unwanted approach
    public MyController() {
        this.greetingService = new GreetingServiceImpl();
    }

    public String sayHello(){
        System.out.println("I'm in the controller");
        return greetingService.sayHello();
    }

}
