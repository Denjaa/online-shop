package com.shop.Shop.service.impl;

import com.shop.Shop.entity.Products;
import com.shop.Shop.repository.ProductRepository;
import com.shop.Shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Products> getAllProducts() {
        return (List<Products>)productRepository.findAll();
    }

    @Override
    public Products getProductById(int ProductId) {
        return productRepository.findById(ProductId).orElse(null);
    }

    @Override
    public Products addOrUpdateProduct(Products product) {
        return productRepository.save(product);
    }

    @Override
    public Products deleteProduct(int ProductId) throws Exception {
        Products deletedProduct = null;
        try {
            deletedProduct = productRepository.findById(ProductId).orElse(null);
            if (deletedProduct == null) {
                throw new Exception("Customer not available in database");
            } else {
                productRepository.deleteById(ProductId);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return deletedProduct;
    }
}
