package com.example.restapi.controller;

import com.example.restapi.entity.Customer;
import com.example.restapi.entity.Product;
import com.example.restapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> findAll() {return customerService.getAllCustomer();}

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable Long id) { return customerService.getCustomer(id);}

    @PostMapping("/customer")
    public Customer addCustomer(@RequestBody Customer customer) { return customerService.addCustomer(customer);}

    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }

    @PatchMapping("/customer/{id}")
    public Customer patchClient(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }


    @DeleteMapping("customer/deleteCustomer/{id}")
    public void deleteCustomer(@PathVariable("id") Customer customer) {
        customerService.deleteCustomer(customer.getId());
    }

}
