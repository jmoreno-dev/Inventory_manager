package com.inventory.enterprise.inventory_manager_api.Repositories;

import com.inventory.enterprise.inventory_manager_api.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByWarehouseId(Long warehouseId);
}
