package com.savin.controller;

import com.savin.dto.customer.CustomerDTO;
import com.savin.dto.customer.CustomerNameAndHomeAndDiscountOnly;
import com.savin.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public CustomerDTO getByIdCustomer(@PathVariable(value = "id") long id){
        return customerService.getByIdCustomer(id);
    }

    @GetMapping("/all")
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PostMapping("/add")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.saveCustomer(customerDTO);
    }

    @PutMapping("/update/full/{id}")
    public ResponseEntity updateFullCustomer(@PathVariable(value = "id") long id,
                                             @RequestBody CustomerDTO customerDTO){
        return customerService.updateFullCustomer(id, customerDTO);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity updatePartial(@PathVariable(value = "id") long id,
                                        @RequestBody CustomerNameAndHomeAndDiscountOnly customerNameAndHomeAndDiscountOnly){
        return customerService.updateCustomer(id, customerNameAndHomeAndDiscountOnly);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable(value = "id") long id){
        return customerService.deleteCustomer(id);
    }
}
