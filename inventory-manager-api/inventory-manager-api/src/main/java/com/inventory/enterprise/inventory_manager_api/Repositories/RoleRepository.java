package com.inventory.enterprise.inventory_manager_api.Repositories;

import com.inventory.enterprise.inventory_manager_api.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
