package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class DogData {
    private String status;
    private List<String> message;
}
