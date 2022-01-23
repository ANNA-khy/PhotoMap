package com.example.PhotoMap.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class ApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
    public ApplicationInitializer(){
        super(SecurityConfig.class);
    }
}
