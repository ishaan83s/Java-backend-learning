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

    //READ by ID
    public ProductDTO getProductById(int id){
        for(ProductEntity entity: productList){
            if (entity.getId() == id){
                ProductDTO dto = new ProductDTO();

                dto.setId(entity.getId());
                dto.setName(entity.getName());
                dto.setPrice(entity.getPrice());
                dto.setQuantity(entity.getQuantity());

                return dto;

            }
        }
        return null;
    }

    //UPDATE
    public ProductDTO updateProduct(int id , ProductDTO dto){
        for(ProductEntity entity:productList){
            if(entity.getId()==id){
                entity.setName(dto.getName());
                entity.setPrice(dto.getPrice());
                entity.setQuantity(dto.getQuantity());

                return dto;
            }
        }
        return null;
    }

    // DELETE
    public boolean deleteProduct(int id) {
        for (ProductEntity entity : productList) {
            if (entity.getId() == id) {
                productList.remove(entity);
                return true; // Successfully found and removed
            }
        }
        return false; // Product with this ID didn't exist
    }
}