package com.example.spring6di.controllers.environments;

import com.example.spring6di.services.environments.BaseEnv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class EnvironmentController {

    @Qualifier("dev")
    //@Autowired
    private final BaseEnv baseEnv;


    @Autowired
    public EnvironmentController(@Qualifier("env") BaseEnv baseEnv) {
        this.baseEnv = baseEnv;
    }

    public String getName(){
        return "This is " +baseEnv.getEnvironment()+ " environment";
    }

}
