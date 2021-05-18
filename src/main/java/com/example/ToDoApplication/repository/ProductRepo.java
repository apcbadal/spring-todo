package com.example.ToDoApplication.repository;

import com.example.ToDoApplication.dto.ProductCategoryDTO;
import com.example.ToDoApplication.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

    @Query(value="select * from Product where uniqueId=:uniqueId order by createdAt desc LIMIT 3 ",nativeQuery = true)
    List<Product> findLatest( @Param("uniqueId") Long uniqueId);

    @Query("select  p from Product  p where p.productCategory.uniqueId=:uniqueId")
    List<Product> findByCategoryId(@Param("uniqueId") Long uniqueId);
}
