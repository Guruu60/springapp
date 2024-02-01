package com.example.myspringapplication;

import com.example.myspringapplication.repository.CustomerRepository;
import com.example.myspringapplication.resource.CustomerController;
import com.example.myspringapplication.service.CustomerService;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CustomerControllerTests {

    Customer cus = new Customer();
    Customer cus1 = new Customer();
    public String str = "Retured successfully";
    public String str1 = null;

    List<Customer> customers = new ArrayList<>();

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
     cus.setCustomer_id("1");
     cus.setCustomer_name("guru");
     cus.setAge(26);
     cus.setP_number("1234567890");

     cus1.setCustomer_id("1");
     cus1.setCustomer_name("guru");
     cus1.setAge(26);
     cus1.setP_number("1234567890");


     customers.add(cus);
    }

    @Test
    void testGetAllCusomterDetails() {
        when(customerService.getCustomerDetails()).thenReturn(customers);
         customers = customerController.getAllCustomerDeatils();
         assertNotNull(customers);
    }
    @Test
    void testGetAllCusomterDetails_forNull() {
        customers = null;
        when(customerService.getCustomerDetails()).thenReturn(customers);
        customers = customerController.getAllCustomerDeatils();
        assertNull(customers);
    }

    @Test
    void testaddAllCusomterDetails(){
        when(customerService.addCustomerDetails(cus)).thenReturn(str);
        str = customerController.addCustomerDeatils(cus1);
        assertNotNull(str);
    }

   @Test
    void testaddAllCusomterDetails_forNull(){
        Mockito.when(customerService.addCustomerDetails(cus)).thenReturn(str);
        str1 = customerController.addCustomerDeatils(cus1);
        assertNull(str1);
    }
}

