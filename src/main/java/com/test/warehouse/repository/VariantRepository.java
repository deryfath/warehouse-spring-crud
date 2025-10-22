package com.test.warehouse.repository;

import com.test.warehouse.entity.Variants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VariantRepository extends JpaRepository<Variants, Long> {
}
