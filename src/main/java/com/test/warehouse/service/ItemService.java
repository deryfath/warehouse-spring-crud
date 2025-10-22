package com.test.warehouse.service;

import com.test.warehouse.entity.Items;
import com.test.warehouse.entity.Variants;
import com.test.warehouse.repository.ItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Items> getAllItems() {
        System.out.println(itemRepository.findAll());
        return itemRepository.findAll();
    }

    public Items getItemById(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Items not found"));
    }

    public Items saveItem(Items items) {
        if (items.getVariants() != null) {
            for (Variants variants : items.getVariants()) {
                variants.setItems(items);
            }
        }
        return itemRepository.save(items);
    }

    @Transactional
    public Items updateItem(Long id, Items newItemData) {
        Items existingItem = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        existingItem.setName(newItemData.getName());

        // Handle variants properly
        if (newItemData.getVariants() != null) {
            // Clear old variants
            existingItem.getVariants().clear();

            // Add new variants and set the relationship back
            for (Variants variant : newItemData.getVariants()) {
                variant.setItems(existingItem);
                existingItem.getVariants().add(variant);
            }
        }

        return itemRepository.save(existingItem);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
