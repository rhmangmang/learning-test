package com.spring.learning.demo.util;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class NeoProperties {
    @Value("${adult.name}")
    private String name;
    @Value("${adult.age}")
    private String description;
}
