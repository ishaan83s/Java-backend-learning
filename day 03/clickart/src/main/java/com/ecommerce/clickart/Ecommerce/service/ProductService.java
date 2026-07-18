package com.ecommerce.clickart.Ecommerce.service;

import com.ecommerce.clickart.Ecommerce.dto.ProductDTO;
import com.ecommerce.clickart.Ecommerce.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    // DUMMY DATABASE
    private List<ProductEntity> productList = new ArrayList<>();

    // CREATE
    public ProductDTO addProduct(ProductDTO dto) {
        ProductEntity entity = new ProductEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setQuantity(dto.getQuantity());

        // db call
        productList.add(entity);
        return dto;
    }

    // READ ALL
    public List<ProductDTO> getAllProduct() {
        List<ProductDTO> dtoList = new ArrayList<>();

        // Loop through all entities, convert them to DTOs, and add to the list
        for (ProductEntity entity : productList) {
            ProductDTO dto = new ProductDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setPrice(entity.getPrice());
            dto.setQuantity(entity.getQuantity());

            dtoList.add(dto);
        }

        return dtoList;
    }
}