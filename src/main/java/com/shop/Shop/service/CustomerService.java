package com.shop.Shop.service;

import com.shop.Shop.entity.Customers;

import java.util.List;

public interface CustomerService {
    public List<Customers> getAllCustomers();
    public Customers getCustomerById(int CustomerId);
    public Customers addOrUpdateCustomer(Customers customer);
    public Customers deleteCustomer(int CustomerId) throws Exception;
}
