package com.inventory.enterprise.inventory_manager_api.Repositories;

import com.inventory.enterprise.inventory_manager_api.Models.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
