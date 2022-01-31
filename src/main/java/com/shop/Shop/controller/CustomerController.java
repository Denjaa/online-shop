package com.shop.Shop.controller;

import com.shop.Shop.entity.Customers;
import com.shop.Shop.models.AuthenticationRequest;
import com.shop.Shop.models.AuthenticationResponse;
import com.shop.Shop.service.CustomerService;
import com.shop.Shop.service.MyUserDetailsService;
import com.shop.Shop.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/allCustomers")
    public ResponseEntity<List<Customers>> getAllCustomers() {
        List<Customers> customers = null;
        try {
            customers = customerService.getAllCustomers();
        } catch(Exception ex) {
            ex.getMessage();
        }

        return new ResponseEntity<List<Customers>>(customers,HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Customers> getCustomer(@PathVariable("id") int customerId) {
        Customers customers = null;
        try {
            customers = customerService.getCustomerById(customerId);
        } catch(Exception ex) {
            ex.getMessage();
        }

        return new ResponseEntity<Customers>(customers,HttpStatus.OK);
    }

    @PostMapping("/addOrUpdate")
    public ResponseEntity<Customers> addOrUpdate(@RequestBody Customers customer) {
        Customers customers = null;
        try {
            customers = customerService.addOrUpdateCustomer(customer);
        } catch(Exception ex) {
            ex.getMessage();
        }

        return new ResponseEntity<Customers>(customers,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customers> deleteCustomer(@PathVariable("id") int customerId) {
        Customers customers = null;
        try {
            customers = customerService.deleteCustomer(customerId);
        } catch(Exception ex) {
            ex.getMessage();
        }

        return new ResponseEntity<Customers>(customers,HttpStatus.OK);
    }


}
