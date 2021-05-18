package com.example.ToDoApplication.Service;

import com.example.ToDoApplication.dto.ProductCategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    void save(ProductCategoryDTO productCategoryDTO);

    List<ProductCategoryDTO> findAll();
}
