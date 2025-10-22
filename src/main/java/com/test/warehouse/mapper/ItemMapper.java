package com.test.warehouse.mapper;

import com.test.warehouse.dto.*;
import com.test.warehouse.entity.*;
import java.util.stream.Collectors;

public class ItemMapper {

    public static ItemDto toDto(Items items) {
        ItemDto dto = new ItemDto();
        dto.setId(items.getId());
        dto.setName(items.getName());

        if (items.getVariants() != null) {
            dto.setVariants(items.getVariants()
                    .stream()
                    .map(ItemMapper::toVariantDto)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public static VariantDto toVariantDto(Variants variants) {
        VariantDto dto = new VariantDto();
        dto.setId(variants.getId());
        dto.setColor(variants.getColor());
        dto.setSize(variants.getSize());
        dto.setPrice(variants.getPrice());
        dto.setStock(variants.getStock());
        return dto;
    }

    public static Variants toEntity(VariantDto dto) {
        Variants variants = new Variants();
        variants.setColor(dto.getColor());
        variants.setSize(dto.getSize());
        variants.setPrice(dto.getPrice());
        variants.setStock(dto.getStock());
        return variants;
    }
}
