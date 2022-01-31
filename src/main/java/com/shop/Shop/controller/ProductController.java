package com.shop.Shop.controller;

import com.shop.Shop.entity.Customers;
import com.shop.Shop.entity.Products;
import com.shop.Shop.service.CustomerService;
import com.shop.Shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/allProducts")
    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> products = null;
        try {
            products = productService.getAllProducts();
        } catch(Exception ex) {
            ex.getMessage();
        }

        return new ResponseEntity<List<Products>>(products, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Products> getProduct(@PathVariable("id") int productId) {
        Products products = null;
        try {
            products = productService.getProductById(productId);
        } catch(Exception ex) {
            ex.getMessage();
        }

        return new ResponseEntity<Products>(products,HttpStatus.OK);
    }

    @PostMapping("/addOrUpdate")
    public ResponseEntity<Products> addOrUpdate(@RequestBody Products product) {
        Products products = null;
        try {
            products = productService.addOrUpdateProduct(product);
        } catch(Exception ex) {
            ex.getMessage();
        }

        return new ResponseEntity<Products>(products,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Products> deleteProduct(@PathVariable("id") int productId) {
        Products products = null;
        try {
            products = productService.deleteProduct(productId);
        } catch(Exception ex) {
            ex.getMessage();
        }

        return new ResponseEntity<Products>(products,HttpStatus.OK);
    }
}
