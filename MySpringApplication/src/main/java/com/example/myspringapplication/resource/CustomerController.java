package com.example.myspringapplication.resource;

import com.example.myspringapplication.Customer;
import com.example.myspringapplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("customerdetails")
    public List<Customer> getAllCustomerDeatils(){
        return customerService.getCustomerDetails();
    }

    @PostMapping("addcustomer")
    public String addCustomerDeatils(@RequestBody Customer customer){
        return  customerService.addCustomerDetails(customer);
    }
    @DeleteMapping("removeCustomer/{customer_id}")
    public String removeCustomerDetails(@PathVariable int customer_id){
        return customerService.removeCustomerDetails(customer_id);
    }
}
