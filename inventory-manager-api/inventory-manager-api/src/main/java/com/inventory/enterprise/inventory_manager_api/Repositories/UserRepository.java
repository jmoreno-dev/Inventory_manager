package com.inventory.enterprise.inventory_manager_api.Repositories;

import com.inventory.enterprise.inventory_manager_api.Models.User;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
