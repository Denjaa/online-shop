package com.shop.Shop.service;

import com.shop.Shop.entity.Customers;
import com.shop.Shop.entity.Products;

import java.util.List;

public interface ProductService {

    public List<Products> getAllProducts();
    public Products getProductById(int ProductId);
    public Products addOrUpdateProduct(Products product);
    public Products deleteProduct(int ProductId) throws Exception;
}
