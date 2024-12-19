package com.example.spring6di.services.greetings;

import org.springframework.stereotype.Service;

@Service("propertyGreetingService")
public class GreetingServicePropertyInjected implements GreetingService {
    @Override
    public String sayHello() {
        return "Hello from Property Injected service";
    }
}
