package com.inventory.enterprise.inventory_manager_api.Services;

import com.inventory.enterprise.inventory_manager_api.DTOs.ProductDTO;
import com.inventory.enterprise.inventory_manager_api.DTOs.ProductRequest;
import com.inventory.enterprise.inventory_manager_api.Models.Product;
import com.inventory.enterprise.inventory_manager_api.Models.Warehouse;
import com.inventory.enterprise.inventory_manager_api.Repositories.ProductRepository;
import com.inventory.enterprise.inventory_manager_api.Repositories.WarehouseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

    // --- Mapeo de Entidad a DTO (Función auxiliar) ---
    private ProductDTO mapToDTO(Product product) {
        if (product == null) return null;

        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setStock(product.getStock());
        dto.setPrice(product.getPrice());

        // Mapear los campos del almacén anidado (1:N)
        if (product.getWarehouse() != null) {
            dto.setWarehouseId(product.getWarehouse().getId());
            dto.setWarehouseName(product.getWarehouse().getName());
        }
        return dto;
    }

    // --- 1. Obtener todos los productos ---
    @Transactional(readOnly = true)
    public List<ProductDTO> findAllProducts() {
        return productRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // --- 2. Obtener productos por almacén (Filtro) ---
    @Transactional(readOnly = true)
    public List<ProductDTO> findProductsByWarehouse(Long warehouseId) {
        return productRepository.findByWarehouseId(warehouseId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // --- 3. Crear un nuevo producto ---
    @Transactional
    public ProductDTO saveNewProduct(ProductRequest request) {
        // 1. Buscar el Warehouse. Si no existe, lanzar excepción
        Warehouse warehouse = warehouseRepository.findById(request.getWarehouseId())
                .orElseThrow(() -> new EntityNotFoundException("Almacén con ID " + request.getWarehouseId() + " no encontrado."));

        // 2. Crear y mapear la Entidad
        Product product = new Product();
        product.setName(request.getName());
        product.setStock(request.getStock());
        product.setPrice(request.getPrice());
        product.setWarehouse(warehouse); // Asignar el objeto Warehouse

        // 3. Guardar y mapear de vuelta a DTO para la respuesta
        Product savedProduct = productRepository.save(product);
        return mapToDTO(savedProduct);
    }

    // --- 4. Lógica de Negocio: Actualizar el Stock ---
    // Este es un método crítico para las entradas y salidas de inventario
    @Transactional
    public ProductDTO updateStock(Long productId, Integer quantityChange) {
        // 1. Buscar el producto o lanzar excepción 404
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Producto con ID " + productId + " no encontrado."));

        // 2. Calcular el nuevo stock
        Integer newStock = product.getStock() + quantityChange;

        // 3. Lógica de validación de Negocio (¡Stock no puede ser negativo!)
        if (newStock < 0) {
            throw new IllegalArgumentException("La operación resulta en stock negativo. Stock actual: " + product.getStock() + ", Cambio solicitado: " + quantityChange);
        }

        // 4. Aplicar el cambio y guardar
        product.setStock(newStock);
        Product updatedProduct = productRepository.save(product);

        // 5. Devolver el DTO del producto actualizado
        return mapToDTO(updatedProduct);
    }

    // --- 5. Eliminar un producto ---
    @Transactional
    public void deleteProduct(Long productId) {
        // Opcional: Puedes verificar si existe antes de borrar si quieres una excepción más limpia.
        if (!productRepository.existsById(productId)) {
            throw new EntityNotFoundException("Producto con ID " + productId + " no encontrado para eliminación.");
        }
        productRepository.deleteById(productId);
    }
}
