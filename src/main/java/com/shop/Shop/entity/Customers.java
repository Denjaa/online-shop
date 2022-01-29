package com.shop.Shop.entity;

import javax.persistence.*;

@Entity
@Table(name="customers")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private int customer_id;

    @Column(name="address")
    private String address;

    @Column(name="email")
    private String email;

    @Column(name="age")
    private int age;

    public Customers() {
        super();
    }

    public Customers(int customer_id, String address, String email, int age) {
        super();
        this.customer_id = customer_id;
        this.address = address;
        this.email = email;
        this.age = age;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
