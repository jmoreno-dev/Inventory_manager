package com.inventory.enterprise.inventory_manager_api.DTOs;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class StockUpdateRequest {
    @NotNull (message = "La cantidad es obligatoria.")
    private Integer quantityChange;
}
