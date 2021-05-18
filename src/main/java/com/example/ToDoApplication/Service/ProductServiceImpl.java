package com.example.ToDoApplication.Service;

import com.example.ToDoApplication.dto.ProductCategoryDTO;
import com.example.ToDoApplication.dto.ProductDTO;
import com.example.ToDoApplication.dto.ProjectDto;
import com.example.ToDoApplication.model.Product;
import com.example.ToDoApplication.model.ProductCategory;
import com.example.ToDoApplication.model.Project;
import com.example.ToDoApplication.repository.ProductCategoryRepo;
import com.google.gson.reflect.TypeToken;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductCategoryRepo productCategoryRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public void save(ProductCategoryDTO productCategoryDTO) {
        ProductCategory productCategory = null;
        Date date = new Date();
        long currentTime = date.getTime();
        Timestamp ts = new Timestamp(currentTime);
        productCategoryDTO.setCreatedAt(ts);
        assert false;
        for (ProductDTO productDTO:productCategoryDTO.getProductList()){
            productDTO.setCreatedAt(ts);
        }
        productCategory=modelMapper.map(productCategoryDTO,ProductCategory.class);
        productCategoryRepo.save(productCategory);
    }

    @Override
    public List<ProductCategoryDTO> findAll() {
        List<ProductCategoryDTO> productCategoryDTOS=null;
        List<ProductCategory> productCategories = productCategoryRepo.findLatestProducts();
        Type targetListType= new TypeToken<List<ProductCategoryDTO>>(){}.getType();
        productCategoryDTOS =modelMapper.map(productCategories,targetListType);
        return productCategoryDTOS;

    }
}
