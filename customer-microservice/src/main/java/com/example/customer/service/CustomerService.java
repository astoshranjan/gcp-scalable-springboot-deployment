package com.example.customer.service;

import java.util.List;
import com.example.customer.entity.Customer;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();
    Customer updateCustomer(Long id, Customer customer);
    void deleteCustomer(Long id);
}