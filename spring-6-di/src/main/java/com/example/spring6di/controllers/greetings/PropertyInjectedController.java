package com.example.spring6di.controllers.greetings;

import com.example.spring6di.services.greetings.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {

    // Dependency injection without Spring
    @Qualifier("propertyGreetingService")
    @Autowired
    GreetingService greetingService;

    public String sayHello() {
       return greetingService.sayHello();
    }

}
