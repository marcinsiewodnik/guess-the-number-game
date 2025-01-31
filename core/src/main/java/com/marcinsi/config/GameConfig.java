package com.marcinsi.config;

import com.marcinsi.annotations.GuessCount;
import com.marcinsi.annotations.MaxNumber;
import com.marcinsi.annotations.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//Configuration class -> based on this class the context is created

@Configuration
@ComponentScan(basePackages = "com.marcinsi")
@PropertySource("classpath:config/game.properties")

public class GameConfig {

    // == fields ==

    @Value("${game.maxNumber:20}")
    private int maxNumber;

    @Value("${game.guessCount:5}")
    private int guessCount;

    @Value("${game.minNumber:5}")
    private int minNumber;

    // == bean methods ==

    @Bean
    @MaxNumber
    public int maxNumber(){

        return maxNumber;
    }

    @Bean
    @MinNumber
    public int minNumber(){

        return minNumber;
    }

    @Bean
    @GuessCount
    public int guessCount(){

        return guessCount;
    }
}
