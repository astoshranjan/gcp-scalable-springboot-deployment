package com.example.customer.controller;

import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

import com.example.customer.entity.Customer;
import com.example.customer.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService service;

    // Manual constructor instead of Lombok
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public Customer create(@Valid @RequestBody Customer customer) {
        return service.createCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable Long id) {
        return service.getCustomerById(id);
    }

    @GetMapping
    public List<Customer> getAll() {
        return service.getAllCustomers();
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable Long id,
                           @Valid @RequestBody Customer customer) {
        return service.updateCustomer(id, customer);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteCustomer(id);
        return "Customer deleted successfully";
    }

    @GetMapping("/health")
    public String health() {
        return "SERVICE RUNNING";
    }
}