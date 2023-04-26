package com.example.test.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.test.entity.Customer} entity
 */
@Data
public class CustomerDTO implements Serializable {
    private final Integer id;
    private final String name;
    private final Byte active;
}