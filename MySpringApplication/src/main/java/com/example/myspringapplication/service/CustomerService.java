package com.example.myspringapplication.service;

import com.example.myspringapplication.Customer;
import com.example.myspringapplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getCustomerDetails() {
        return customerRepository.findAll();
    }

    public String addCustomerDetails(Customer customer) {
        try {
            customerRepository.save(customer);
        }
        catch (Exception e){
            return "Enter correct value";
        }
         return "Successfully updated record";
    }

    public String removeCustomerDetails(int customer_id) {
        if (customerRepository.findById(customer_id).isPresent()){
            customerRepository.deleteById(customer_id);
        }
        else {
            return "Check the Customer ID";
        }

        return "Successfully removed Customer";
    }
}
