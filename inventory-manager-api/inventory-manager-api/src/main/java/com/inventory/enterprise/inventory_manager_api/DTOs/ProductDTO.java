package com.inventory.enterprise.inventory_manager_api.DTOs;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private Integer stock;
    private BigDecimal price;

    private Long warehouseId;
    private String warehouseName;

}
