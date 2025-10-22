package com.test.warehouse.controller;

import com.test.warehouse.dto.ItemDto;
import com.test.warehouse.entity.Items;
import com.test.warehouse.mapper.ItemMapper;
import com.test.warehouse.service.ItemService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<ItemDto> getAllItems() {
        return itemService.getAllItems().stream()
                .map(ItemMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ItemDto getItemById(@PathVariable Long id) {
        return ItemMapper.toDto(itemService.getItemById(id));
    }

    @PostMapping
    public ItemDto createItem(@RequestBody Items items) {
        return ItemMapper.toDto(itemService.saveItem(items));
    }

    @PutMapping("/{id}")
    public ItemDto updateItem(@PathVariable Long id, @RequestBody Items items) {
        return ItemMapper.toDto(itemService.updateItem(id, items));
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }
}
