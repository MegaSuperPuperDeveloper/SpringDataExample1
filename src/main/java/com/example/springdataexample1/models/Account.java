package com.example.springdataexample1.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
public class Account {
    @Id
    private long id;
    private String name;
    private BigDecimal amount;
}