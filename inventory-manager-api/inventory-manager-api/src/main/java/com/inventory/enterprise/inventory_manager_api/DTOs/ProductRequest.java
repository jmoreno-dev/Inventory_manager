package com.inventory.enterprise.inventory_manager_api.DTOs;

import jakarta.validation.constraints.*;
import lombok.Getter;

import java.math.BigDecimal;

public class ProductRequest {
@NotBlank(message = "El nombre es obligatorio.")
@Size(max = 150, message = "El nombre no debe exceder los 150 caracteres.")
private String name;

@Size(max = 500, message = "La descripción no debe exceder los 500 caracteres.")
private String description;

@NotNull(message = "El stock inicial es obligatorio.")
@Min(value = 0, message = "El stock no puede ser negativo.")
private Integer stock;

@NotNull(message = "El precio es obligatorio.")
@DecimalMin(value = "0.01", message = "El precio debe ser mayor a cero.")
private BigDecimal price;

@Getter
@NotNull(message = "El ID del almacén es obligatorio.")
private Long warehouseId;

}
