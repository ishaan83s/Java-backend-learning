package com.ecommerce.clickart.Ecommerce.controllers;

import com.ecommerce.clickart.Ecommerce.dto.ProductDTO;
import com.ecommerce.clickart.Ecommerce.service.ProductService;
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

    // CREATE
    @PostMapping
//    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO dto) {
//        ProductDTO savedProduct = productService.addProduct(dto);
//        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    public ProductDTO addProduct(@RequestBody ProductDTO dto){
        return productService.addProduct(dto);

    }

    // READ ALL
    @GetMapping
    public List<ProductDTO>getAllProducts(){
        return productService.getAllProduct();
    }
//    public ResponseEntity<List<ProductDTO>> getAllProducts() {
//        List<ProductDTO> products = productService.getAllProduct();
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable int id) {
        ProductDTO dto = productService.getProductById(id);
        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Returns 404 if product doesn't exist
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable int id, @RequestBody ProductDTO dto) {
        ProductDTO updatedProduct = productService.updateProduct(id, dto);
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        boolean isDeleted = productService.deleteProduct(id);
        if (isDeleted) {
            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    }
}