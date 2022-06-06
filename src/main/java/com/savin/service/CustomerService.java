package com.savin.service;

import com.savin.dto.customer.CustomerDTO;
import com.savin.dto.customer.CustomerNameAndHomeAndDiscountOnly;
import com.savin.mapper.CustomerMapper;
import com.savin.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper mapper) {
        this.customerRepository = customerRepository;
        this.mapper = mapper;
    }

    public CustomerDTO getByIdCustomer(long id){
        return customerRepository.findById(id)
                .map(mapper::fromCustomerToDTO)
                .orElseThrow();
    }

    public List<CustomerDTO> getAllCustomers(){
        return customerRepository.findAll()
                .stream()
                .map(mapper::fromCustomerToDTO)
                .collect(Collectors.toList());
    }

    public CustomerDTO saveCustomer(CustomerDTO customerDTO){
        return Optional.of(customerDTO)
                .map(mapper::fromDTOToCustomer)
                .map(customerRepository::save)
                .map(mapper::fromCustomerToDTO)
                .orElseThrow();
    }

    public ResponseEntity updateFullCustomer(long id, CustomerDTO customerDTO){
        return customerRepository.findById(id)
                .map(update -> { mapper.updateFull(customerDTO, update);
                    customerRepository.save(update);

                    return new ResponseEntity("Изменения внесены", HttpStatus.OK);
                }).orElseThrow();
    }

    public ResponseEntity updateCustomer(long id, CustomerNameAndHomeAndDiscountOnly customerNameAndHomeAndDiscountOnly){
        return customerRepository.findById(id)
                .map(update -> { mapper.updatePartial(customerNameAndHomeAndDiscountOnly, update);
                    customerRepository.save(update);

                    return new ResponseEntity("Изменения внесены", HttpStatus.OK);
                }).orElseThrow();
    }

    public String deleteCustomer(long id){
        return customerRepository.findById(id)
                .map(delete -> { customerRepository.delete(delete);

                    return delete.getId() + ". Покупатель удален: " + delete.getSurname();
                }).orElseThrow();
    }
}
