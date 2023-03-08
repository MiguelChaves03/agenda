package com.ejercicio.Agenda.config;

import org.springframework.context.annotation.*;
import org.modelmapper.*;

@Configuration
public class AppConfiguration {

    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();

    }

}
