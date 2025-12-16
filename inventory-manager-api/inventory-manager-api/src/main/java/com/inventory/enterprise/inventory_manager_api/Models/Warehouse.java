package com.inventory.enterprise.inventory_manager_api.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "warehouses")
@Data
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "name", nullable = false, unique = true)
    private String name;

    @Column (name = "location", nullable = false)
    private String location;
}
