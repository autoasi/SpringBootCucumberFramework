package com.autoasi.springselenium.app.config;

import com.autoasi.springselenium.app.annotation.LazyConfiguration;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class FakerConfig {

    @Bean
    public Faker getFaker(){
        return new Faker();
    }
}
