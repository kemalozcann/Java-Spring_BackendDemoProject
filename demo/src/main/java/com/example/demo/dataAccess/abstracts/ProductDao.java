package com.example.demo.dataAccess.abstracts;

import com.example.demo.entities.Dtos.ProductWithCategoryDto;
import com.example.demo.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {

    Product getByProductName(String productName);
    Product getByProductNameAndCategory_CategoryId(String productName ,int categoryId);
    List<Product>getByProductNameOrCategory_CategoryId(String productName ,int categoryId);


    @Query("from Product where productName=:productName and category.categoryId=:categoryId")
    List<Product>getByNameAndCategory_CategoryId(String productName,int categoryId);

    @Query("select new com.example.demo.entities.Dtos.ProductWithCategoryDto" +
            "(p.id,p.productName,c.categoryName) " +
            "from Category c inner join c.products p")
    List<ProductWithCategoryDto>getProductWithCategoryDetails();

}

