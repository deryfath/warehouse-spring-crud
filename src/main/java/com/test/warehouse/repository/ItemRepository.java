package com.test.warehouse.repository;

import com.test.warehouse.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Items, Long> {
}
