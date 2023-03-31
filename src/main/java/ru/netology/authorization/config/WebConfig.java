package ru.netology.authorization.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class WebConfig {
    @Bean
    public ConcurrentHashMap<String, String> concurrentHashMapStrStr() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("test1", "qwerty1");
        map.put("test2", "1234567");

        return map;
    }
}
