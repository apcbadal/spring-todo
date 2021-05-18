package com.example.ToDoApplication.Service;

import com.example.ToDoApplication.dto.ProductCategoryDTO;
import com.example.ToDoApplication.dto.ProductDTO;
import com.example.ToDoApplication.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    void save(ProductCategoryDTO productCategoryDTO);

    List<ProductCategoryDTO> findAll();

    List<Product> findProductById(Long uniqueId);

    List<ProductDTO> findProductByCategoryId(Long id);
}
