package com.example.demo.business.abstracts;
import com.example.demo.core.result.DataResult;
import com.example.demo.core.result.Result;
import com.example.demo.entities.Dtos.ProductWithCategoryDto;
import com.example.demo.entities.concretes.Product;


import java.util.List;


public interface ProductService {
    DataResult<List<Product>>getAll();
    DataResult<List<Product>>getAll(int pageNo,int pageSize);
    DataResult<List<Product>>getAllShorted();

    Result add(Product product);

    DataResult<Product> getByProductName(String productName);
    DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId);
    DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName,int categoryId);
    DataResult<List<Product>>getByNameAndCategory_CategoryId(String productName,int categoryId);
    DataResult<List<ProductWithCategoryDto>>getProductWithCategoryDetails();




}
