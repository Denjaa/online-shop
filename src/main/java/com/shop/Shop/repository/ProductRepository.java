package com.shop.Shop.repository;

import com.shop.Shop.entity.Customers;
import com.shop.Shop.entity.Products;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Products, Integer> {
}
