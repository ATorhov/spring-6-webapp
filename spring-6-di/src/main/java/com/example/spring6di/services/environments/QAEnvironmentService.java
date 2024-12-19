package com.example.spring6di.services.environments;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("qa")
@Service("env")
public class QAEnvironmentService implements BaseEnv{
    @Override
    public String getEnvironment() {
        return "QA";
    }
}
