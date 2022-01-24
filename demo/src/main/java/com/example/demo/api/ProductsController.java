package com.example.demo.api;
import com.example.demo.business.abstracts.ProductService;
import com.example.demo.core.result.DataResult;
import com.example.demo.core.result.Result;
import com.example.demo.entities.Dtos.ProductWithCategoryDto;
import com.example.demo.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/products/")
public class ProductsController {
    @Autowired
     private ProductService productService;
    @GetMapping("getAll")
    public DataResult<List<Product>> getAll() {
    return this.productService.getAll();
    }
    @PostMapping("add")
    public Result add(@RequestBody Product product)
    {
        return this.productService.add(product);
    }
    @GetMapping("getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName)
    {
        return this.productService.getByProductName(productName);
    }
    @GetMapping("getByProductNameAndCategory")
    public DataResult<Product> getByProductNameAndCategory_CategoryId(@RequestParam String productName,@RequestParam int categoryId)
    {
        return this.productService.getByProductNameAndCategory_CategoryId(productName,categoryId);
    }
    @GetMapping("getByProductNameOrCategory")
    public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(@RequestParam String productName,@RequestParam int categoryId)
    {
        return this.productService.getByProductNameOrCategory_CategoryId(productName,categoryId);
    }
    @GetMapping("getByNameAndCategory")
    public DataResult<List<Product>>getByNameAndCategory_CategoryId(@RequestParam String productName,@RequestParam int categoryId)
    {
        return   this.productService.getByNameAndCategory_CategoryId(productName,categoryId);
    }
    @GetMapping("getAllByPage")
    public DataResult<List<Product>> getAllByPage( int pageNo, int pageSize)
    {
        return this.productService.getAll(pageNo,pageSize);
    }
    @GetMapping("getAllByShortedAsc")
    public DataResult<List<Product>>getAllShorted()
    {
        return this.productService.getAllShorted();
    }
    @GetMapping("getProductWithCategoryDetail")
    DataResult<List<ProductWithCategoryDto>>getProductWithCategoryDetails()
    {
        return this.productService.getProductWithCategoryDetails();
    }

}
