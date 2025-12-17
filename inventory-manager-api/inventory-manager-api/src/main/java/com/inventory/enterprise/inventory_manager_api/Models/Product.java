package com.inventory.enterprise.inventory_manager_api.Models;

import jakarta.persistence.*;
import jakarta.persistence.metamodel.EntityType;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table (name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name="name", nullable = false)
    private String name;

    @Column (name="stock", nullable = false)
    private int stock;

    @Column (name="price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;

}
