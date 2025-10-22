package com.test.warehouse.dto;

import lombok.Data;

@Data
public class VariantDto {
    private Long id;
    private String color;
    private String size;
    private Double price;
    private Integer stock;

    // Getters and Setters
}
