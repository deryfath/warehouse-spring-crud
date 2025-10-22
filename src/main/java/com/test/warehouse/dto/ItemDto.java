package com.test.warehouse.dto;

import lombok.Data;

import java.util.List;

@Data
public class ItemDto {
    private Long id;
    private String name;
    private List<VariantDto> variants;
}
