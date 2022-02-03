package com.example.PhotoMap.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class ApplicationSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    public ApplicationSecurityInitializer(){
        super(SecurityConfig.class);
    }
}
