package com.example.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // Define Course bean
    @Bean
    public Course course() {
        return new Course();
    }

    // Define Student bean and inject Course
    @Bean
    public Student student() {
        return new Student(course());
    }
}
