package com.example.demo.business.concretes;

import java.util.List;
import com.example.demo.business.abstracts.ProductService;
import com.example.demo.core.result.DataResult;
import com.example.demo.core.result.Result;
import com.example.demo.core.result.SuccessDataResult;
import com.example.demo.core.result.SuccessResult;
import com.example.demo.dataAccess.abstracts.ProductDao;
import com.example.demo.entities.Dtos.ProductWithCategoryDto;
import com.example.demo.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
 public class ProductManager implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"Data listelendi.");
    }
    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable= PageRequest.of(pageNo-1,pageSize);
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent()," ");
    }
    @Override
    public DataResult<List<Product>> getAllShorted() {
        Sort sort= Sort.by(Sort.Direction.ASC,"productName");
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort)," ");
    }
    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("ürün eklendi");
    }
    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>(this.productDao.getByProductName(productName),"data listelendi");
    }
    @Override
    public DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data listelendi.");
    }
    @Override
    public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId),"Data listelendi.");
    }
    @Override
    public DataResult<List<Product>> getByNameAndCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory_CategoryId(productName,categoryId)," ok");
    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails()," ok");
    }


}
