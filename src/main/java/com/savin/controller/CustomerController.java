package com.savin.controller;

import com.savin.dto.customer.CustomerDTO;
import com.savin.dto.customer.CustomerHomeDTO;
import com.savin.dto.customer.CustomerNameAndHomeAndDiscountOnly;
import com.savin.dto.customer.CustomerSurnameAndDiscountDTO;
import com.savin.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Получение клиента по id")
    @GetMapping("/{id}")
    public CustomerDTO getByIdCustomer(@PathVariable(value = "id") long id){
        return customerService.getByIdCustomer(id);
    }

    @Operation(summary = "Получение всех клиентов")
    @GetMapping("/all")
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @Operation(summary = "Добавление клиента")
    @PostMapping("/add")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.saveCustomer(customerDTO);
    }

    @Operation(summary = "Полное обновление клиента")
    @PutMapping("/update/full/{id}")
    public ResponseEntity updateFullCustomer(@PathVariable(value = "id") long id,
                                             @RequestBody CustomerDTO customerDTO){
        return customerService.updateFullCustomer(id, customerDTO);
    }

    @Operation(summary = "Частичное обновление клиента")
    @PatchMapping("/update/{id}")
    public ResponseEntity updatePartial(@PathVariable(value = "id") long id,
                                        @RequestBody CustomerNameAndHomeAndDiscountOnly customerNameAndHomeAndDiscountOnly){
        return customerService.updateCustomer(id, customerNameAndHomeAndDiscountOnly);
    }

    @Operation(summary = "Удаление клиента по id")
    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable(value = "id") long id){
        return customerService.deleteCustomer(id);
    }

    @Operation(summary = "Получение различных районов, в которых проижвают клиенты")
    @GetMapping("/home-different")
    public List<CustomerHomeDTO> getDifferentHomeCustomer(){
        return customerService.getDifferentHomeCustomer();
    }

    @Operation(summary = "Получение клиентов и их скидки, которые проживают в указанном районе")
    @GetMapping("/info/{home}")
    public List<CustomerSurnameAndDiscountDTO> getInfo(@PathVariable(value = "home") String home){
        return customerService.getInfo(home);
    }
}
