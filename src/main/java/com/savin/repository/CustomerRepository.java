package com.savin.repository;

import com.savin.dto.customer.CustomerHomeDTO;
import com.savin.dto.customer.CustomerSurnameAndDiscountDTO;
import com.savin.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT DISTINCT new com.savin.dto.customer.CustomerHomeDTO(home) FROM Customer")
    List<CustomerHomeDTO> getDifferentHomeCustomer();

    @Query(value = "SELECT new com.savin.dto.customer.CustomerSurnameAndDiscountDTO(surname, discount) FROM Customer WHERE home = :home")
    List<CustomerSurnameAndDiscountDTO> getCustomersInfo(String home);
}
