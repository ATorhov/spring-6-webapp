package com.example.spring6di.controllers.greetings;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PropertyInjectedControllerTest {

    @Autowired
    PropertyInjectedController controller;

    // Dependency injection without Spring
//    @BeforeEach
//    void setUp() {
//        controller = new PropertyInjectedController();
//        controller.greetingService = new GreetingServiceImpl();
//    }

    @Test
    void sayHello() {
        System.out.println(controller.sayHello());
    }
}