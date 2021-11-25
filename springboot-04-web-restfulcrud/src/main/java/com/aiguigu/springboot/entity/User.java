package com.aiguigu.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
@ConfigurationProperties(prefix="user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors
public class User {
    private Integer id;
    private String name;
    private String gender;
    private Date bir;
    private Map<String,String> maps;

}
