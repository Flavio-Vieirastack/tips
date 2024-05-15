package com.initbinder.initBinder.Condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    @Conditional(MyCondition.class)
    public MyBean bean() {
        return new MyBean();

    }
}
