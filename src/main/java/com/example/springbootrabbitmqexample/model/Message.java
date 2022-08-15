package com.example.springbootrabbitmqexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    // greeting receiver
    private String to;

    // greeting content
    private String message;
}
