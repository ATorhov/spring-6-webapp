package com.example.spring6di.services.environments;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"uat", "default"})
@Service("env")
public class UATEnvironmentService implements BaseEnv{
    @Override
    public String getEnvironment() {
        return "UAT";
    }
}
