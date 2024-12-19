package com.example.spring6di.services.environments;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("dev")
@Service("env")
public class DevEnvironmentService implements BaseEnv{
    @Override
    public String getEnvironment() {
        return "DEV";
    }
}
