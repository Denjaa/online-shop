package com.shop.Shop.repository;

import com.shop.Shop.entity.Customers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customers, Integer> {
}
