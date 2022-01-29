package com.shop.Shop.service.impl;

import com.shop.Shop.entity.Customers;
import com.shop.Shop.repository.CustomerRepository;
import com.shop.Shop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepostiroty;


    @Override
    public List<Customers> getAllCustomers() {
        return (List<Customers>)customerRepostiroty.findAll();
    }

    @Override
    public Customers getCustomerById(int CustomerId) {
        return customerRepostiroty.findById(CustomerId).orElse(null);
    }

    @Override
    public Customers addOrUpdateCustomer(Customers customer) {
        return customerRepostiroty.save(customer);
    }

    @Override
    public Customers deleteCustomer(int CustomerId) throws Exception {
        Customers deletedUser = null;
        try {
            deletedUser = customerRepostiroty.findById(CustomerId).orElse(null);
            if (deletedUser == null) {
                throw new Exception("Customer not available in database");
            } else {
                customerRepostiroty.deleteById(CustomerId);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return deletedUser;
    }
}
