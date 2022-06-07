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
    @Mapping(target = "shop.id", source = "buyingDTO.shop_id")
    @Mapping(target = "customer.id", source = "buyingDTO.customer_id")
    @Mapping(target = "books.id", source = "buyingDTO.books_id")
    Buying fromDTOToBuying(BuyingDTO buyingDTO);

    @Mapping(target = "shop_id", source = "buying.shop.id")
    @Mapping(target = "customer_id", source = "buying.customer.id")
    @Mapping(target = "books_id", source = "buying.books.id")
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