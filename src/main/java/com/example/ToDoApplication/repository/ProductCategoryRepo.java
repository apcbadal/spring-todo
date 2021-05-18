package com.example.ToDoApplication.repository;

import com.example.ToDoApplication.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepo extends JpaRepository<ProductCategory,Long> {
@Query(value = "select * from product left outer  join product_category pc on product.product_category = pc.unique_id order by product.created_at limit 3\n",nativeQuery = true)
    List<ProductCategory> findLatestProducts();
}
