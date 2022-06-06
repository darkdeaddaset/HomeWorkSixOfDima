package com.savin.mapper;

import com.savin.dto.customer.CustomerDTO;
import com.savin.dto.customer.CustomerNameAndHomeAndDiscountOnly;
import com.savin.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer fromDTOToCustomer(CustomerDTO customerDTO);
    CustomerDTO fromCustomerToDTO(Customer customer);
    void updatePartial(CustomerNameAndHomeAndDiscountOnly customerNameAndHomeAndDiscountOnly,
                       @MappingTarget Customer customer);
    @Mapping(target = "id", ignore = true)
    void updateFull(CustomerDTO customerDTO, @MappingTarget Customer customer);
}
