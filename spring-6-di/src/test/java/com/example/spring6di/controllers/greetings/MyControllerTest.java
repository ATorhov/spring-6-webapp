package com.example.spring6di.controllers.greetings;

import org.junit.jupiter.api.Test;

class MyControllerTest {


    // Dependency without injection - unwanted approach
    @Test
    void sayHello() {
        MyController myController = new MyController();
        System.out.println(myController.sayHello());
    }
}