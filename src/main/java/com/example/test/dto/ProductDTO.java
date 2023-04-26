package com.example.test.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.test.entity.Product} entity
 */
@Data
public class ProductDTO implements Serializable {
    private final Integer idProduct;
    private final String clave;
    private final String description;
    private final byte active;
}