package com.example.ToDoApplication.repository;

import com.example.ToDoApplication.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepo extends JpaRepository<ProductCategory,Long> {
@Query(value = "select * from ProductCategory",nativeQuery = true)
    List<ProductCategory> findLatestProducts();
}
