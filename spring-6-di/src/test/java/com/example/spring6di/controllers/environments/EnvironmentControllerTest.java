package com.example.spring6di.controllers.environments;

import com.example.spring6di.services.environments.BaseEnv;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("qa")
class EnvironmentControllerTest {

    @Autowired
    EnvironmentController environmentController;

    @Test
    void getName() {
        System.out.println(environmentController.getName());
    }
}