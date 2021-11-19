package org.launchcode.javawebdevtechjobsauthentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.launchcode.javawebdevtechjobsauthentication.*;
import org.launchcode.javawebdevtechjobsauthentication.controllers.*;
import org.launchcode.javawebdevtechjobsauthentication.models.*;
import org.launchcode.javawebdevtechjobsauthentication.models.data.*;
import org.springframework.web.servlet.handler.*;
import javax.servlet.http.*;


@Configuration
public class WebApplicationConfig implements WebMvcConfigurer {

    // Create spring-managed object to allow the app to access our filter
    @Bean
    public HandlerInterceptor authenticationFilter() {
        return new AuthenticationFilter();
    }

    // Register the filter with the Spring container
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationFilter());
    }

}
