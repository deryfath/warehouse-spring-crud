package com.test.warehouse.service;

import com.test.warehouse.entity.Items;
import com.test.warehouse.entity.Variants;
import com.test.warehouse.repository.ItemRepository;
import com.test.warehouse.repository.VariantRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class VariantService {

    private final VariantRepository variantRepository;
    private final ItemRepository itemRepository;

    public VariantService(VariantRepository variantRepository, ItemRepository itemRepository) {
        this.variantRepository = variantRepository;
        this.itemRepository = itemRepository;
    }

    public List<Variants> getAllVariants() {
        return variantRepository.findAll();
    }

    public Variants getVariantById(Long id) {
        return variantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Variants not found"));
    }

    public Variants createVariant(Long itemId, Variants variants) {
        Items items = itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Items not found"));
        variants.setItems(items);
        return variantRepository.save(variants);
    }

    public Variants updateVariant(Long itemId, Variants variantsRequest) {
        Variants variants = getVariantById(variantsRequest.getId());
        variants.setColor(variantsRequest.getColor());
        variants.setSize(variantsRequest.getSize());
        variants.setPrice(variantsRequest.getPrice());
        variants.setStock(variantsRequest.getStock());
        Items items = itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Items not found"));
        variants.setItems(items);
        return variantRepository.save(variants);
    }

    public void deleteVariant(Long id) {
        variantRepository.deleteById(id);
    }

    public void reduceStock(Long variantId, int quantity) {
        Variants variants = getVariantById(variantId);
        if (variants.getStock() < quantity) {
            throw new RuntimeException("Not enough stock for variants ID: " + variantId);
        }
        variants.setStock(variants.getStock() - quantity);
        variantRepository.save(variants);
    }
}
