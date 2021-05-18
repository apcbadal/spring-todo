package com.example.ToDoApplication.Service;

import com.example.ToDoApplication.dto.ProductCategoryDTO;
import com.example.ToDoApplication.dto.ProductDTO;
import com.example.ToDoApplication.dto.ProjectDto;
import com.example.ToDoApplication.model.Product;
import com.example.ToDoApplication.model.ProductCategory;
import com.example.ToDoApplication.model.Project;
import com.example.ToDoApplication.repository.ProductCategoryRepo;
import com.example.ToDoApplication.repository.ProductRepo;
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

    @Autowired
    ProductRepo productRepo;
    @Override
    public void save(ProductCategoryDTO productCategoryDTO) {
        ProductCategory productCategory = null;
        Date date = new Date();
        long currentTime = date.getTime();
        Timestamp ts = new Timestamp(currentTime);
        productCategoryDTO.setCreatedAt(ts);
        assert false;
        productCategory=modelMapper.map(productCategoryDTO,ProductCategory.class);
        for (Product product:productCategory.getProductList()){
            product.setCreatedAt(ts);
        }
        productCategoryRepo.save(productCategory);
    }

    @Override
    public List<ProductCategoryDTO> findAll() {
        List<ProductCategoryDTO> productCategoryDTOS=null;
        List<ProductCategory> productCategories = productCategoryRepo.findAll();
        Type targetListType= new TypeToken<List<ProductCategoryDTO>>(){}.getType();
        productCategoryDTOS =modelMapper.map(productCategories,targetListType);
        return productCategoryDTOS;

    }

    @Override
    public List<Product> findProductById(Long uniqueId) {
        List<Product> products = productRepo.findLatest(uniqueId);
        return products;
    }

    @Override
    public List<ProductDTO> findProductByCategoryId(Long id) {
        List<ProductDTO> productDTOS =null;
        List<Product> products =productRepo.findByCategoryId(id);
        Type targetListType= new TypeToken<List<ProductDTO>>(){}.getType();
        productDTOS =modelMapper.map(products,targetListType);
        return productDTOS;
    }
}
