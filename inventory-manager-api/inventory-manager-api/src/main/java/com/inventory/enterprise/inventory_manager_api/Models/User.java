package com.inventory.enterprise.inventory_manager_api.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "users")
@Data
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name="username", nullable = false, unique = true)
    private String username;

    @Column (name = "password",nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private String role;
}
