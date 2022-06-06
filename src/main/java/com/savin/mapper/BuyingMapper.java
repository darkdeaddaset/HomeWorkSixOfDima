package com.savin.mapper;

import com.savin.dto.buying.BuyingCustomerOnly;
import com.savin.dto.buying.BuyingDTO;
import com.savin.dto.buying.BuyingQuantityOnly;
import com.savin.dto.buying.BuyingShopOnly;
import com.savin.model.Buying;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BuyingMapper {
    @Mapping(target = "shop", source = "buyingDTO.shop")
    @Mapping(target = "customer", source = "buyingDTO.customer")
    @Mapping(target = "books", source = "buyingDTO.books")
    Buying fromDTOToBuying(BuyingDTO buyingDTO);

    @Mapping(target = "shop", source = "buying.shop")
    @Mapping(target = "customer", source = "buying.customer")
    @Mapping(target = "books", source = "buying.books")
    BuyingDTO fromBuyingToDTO(Buying buying);
    void updatePartialShop(BuyingShopOnly buyingShopOnly,
                           @MappingTarget Buying buying);
    void updatePartialCustomer(BuyingCustomerOnly buyingCustomerOnly,
                               @MappingTarget Buying buying);
    void updatePartialQuantity(BuyingQuantityOnly buyingQuantityOnly,
                               @MappingTarget Buying buying);
    @Mapping(target = "id", ignore = true)
    void updateFull(BuyingDTO buyingDTO, @MappingTarget Buying buying);
}