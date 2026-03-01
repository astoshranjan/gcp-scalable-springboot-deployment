package com.example.customer.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.customer.entity.Customer;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.exception.ResourceNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    // Manual constructor instead of Lombok
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Customer existing = getCustomerById(id);
        existing.setName(customer.getName());
        existing.setEmail(customer.getEmail());
        existing.setAge(customer.getAge());
        return repository.save(existing);
    }

    @Override
    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }
}