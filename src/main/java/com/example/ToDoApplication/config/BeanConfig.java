package com.example.ToDoApplication.config;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper mapper = new ModelMapper();
        return mapper;
    }
    @Bean
    public Gson gson(){
        Gson gson = new Gson();
        return gson;
    }
}
