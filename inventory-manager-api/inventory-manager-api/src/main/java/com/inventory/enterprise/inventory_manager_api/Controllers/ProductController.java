package com.inventory.enterprise.inventory_manager_api.Controllers;

import com.inventory.enterprise.inventory_manager_api.DTOs.ProductDTO;
import com.inventory.enterprise.inventory_manager_api.DTOs.ProductRequest;
import com.inventory.enterprise.inventory_manager_api.DTOs.StockUpdateRequest;
import com.inventory.enterprise.inventory_manager_api.Services.ProductService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    // --- 1. GET: Obtener todos los productos ---
    // GET /api/products
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.findAllProducts();
        return ResponseEntity.ok(products);
    }

    // --- 2. GET: Obtener productos por almacén (Filtro) ---
    // GET /api/products?warehouseId=1
    @GetMapping(params = "warehouseId")
    public ResponseEntity<List<ProductDTO>> getProductsByWarehouse(@RequestParam Long warehouseId) {
        List<ProductDTO> products = productService.findProductsByWarehouse(warehouseId);
        return ResponseEntity.ok(products);
    }

    // --- 3. POST: Crear un nuevo producto ---
    // POST /api/products
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductRequest productRequest) {
        // Asumo que tienes un método 'saveNewProduct' en ProductService
        // ProductDTO newProduct = productService.saveNewProduct(productRequest);
        // return new ResponseEntity<>(newProduct, HttpStatus.CREATED);

        // Placeholder temporal:
        return new ResponseEntity<>(new ProductDTO(), HttpStatus.CREATED);
    }

    // --- 4. PUT: Actualizar stock (Lógica de Negocio Clave) ---
    // PUT /api/products/{id}/stock
    @PutMapping("/{id}/stock")
    public ResponseEntity<?> updateStock(@PathVariable Long id,
                                         @Valid @RequestBody StockUpdateRequest stockUpdateRequest) {
        try {
            ProductDTO updatedProduct = productService.updateStock(id, stockUpdateRequest.getQuantityChange());
            return ResponseEntity.ok(updatedProduct);
        } catch (EntityNotFoundException e) {
            // Producto no encontrado
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND); // 404
        } catch (IllegalArgumentException e) {
            // Lógica de negocio (ej. stock negativo)
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST); // 400
        }
    }

    // --- 5. DELETE: Eliminar un producto ---
    // DELETE /api/products/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        // productService.deleteProduct(id); // Asumo que tienes este método en el servicio
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
    }
}
