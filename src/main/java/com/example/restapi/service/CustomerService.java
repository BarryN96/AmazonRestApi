package com.example.restapi.service;

import com.example.restapi.entity.Customer;
import com.example.restapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Wiedergibt alle Zeilen der tabelle und füllt die List mit objekten
    public List<Customer> getAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    // Gibt Customer von der gegebenene id zurück
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    // Gibt Customer mit gegebenem Namen zurück
    public List<Customer> getByName(String name){
        return customerRepository.findAll().stream().filter(x -> x.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
    }

    // Customer in die Tabelle einfügen
    public Customer addCustomer(Customer costumer) {
        return customerRepository.save(costumer);
    }

    // Costumer updaten
    public Customer updateCustomer(Long id, Customer customerInfo) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if(customer != null) {
            customer.setName(customerInfo.getName());
            customerRepository.save(customer);
        }
        return customer;
    }

    //delete
    public String deleteCustomer(Long id) {
        try {
            customerRepository.deleteById(id);
            return String.format("Customer was deleted");
        } catch (Exception e) {
            return String.format("Customer not found");
        }


    }



}
