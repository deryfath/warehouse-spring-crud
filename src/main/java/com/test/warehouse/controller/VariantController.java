package com.test.warehouse.controller;

import com.test.warehouse.dto.SellRequestDto;
import com.test.warehouse.dto.VariantDto;
import com.test.warehouse.entity.Variants;
import com.test.warehouse.mapper.ItemMapper;
import com.test.warehouse.service.VariantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/variants")
public class VariantController {

    private final VariantService variantService;

    public VariantController(VariantService variantService) {
        this.variantService = variantService;
    }

    @GetMapping
    public List<VariantDto> getAllVariants() {
        return variantService.getAllVariants()
                .stream()
                .map(ItemMapper::toVariantDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public VariantDto getVariantById(@PathVariable Long id) {
        return ItemMapper.toVariantDto(variantService.getVariantById(id));
    }

    @PostMapping("/item/{itemId}")
    public VariantDto createVariant(@PathVariable Long itemId, @RequestBody Variants variants) {
        return ItemMapper.toVariantDto(variantService.createVariant(itemId, variants));
    }

    @PutMapping("/item/{itemId}")
    public VariantDto updateVariant(@PathVariable Long itemId, @RequestBody Variants variants) {
        return ItemMapper.toVariantDto(variantService.updateVariant(itemId, variants));
    }

    @DeleteMapping("/{id}")
    public void deleteVariant(@PathVariable Long id) {
        variantService.deleteVariant(id);
    }

    @PostMapping("/{id}/sell")
    public VariantDto reduceStock(@PathVariable Long id, @RequestBody SellRequestDto sellRequestDto) {
        variantService.reduceStock(id, sellRequestDto.getQuantity());
        return ItemMapper.toVariantDto(variantService.getVariantById(id));
    }
}
