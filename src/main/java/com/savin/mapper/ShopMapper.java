package com.savin.mapper;

import com.savin.dto.shop.ShopAreaAndCommissaryOnly;
import com.savin.dto.shop.ShopDTO;
import com.savin.model.Shop;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ShopMapper {
    Shop fromDTOToShop(ShopDTO shopDTO);
    ShopDTO fromShopToShopDTO(Shop shop);
    void updatePartial(ShopAreaAndCommissaryOnly shopAreaAndCommissaryOnly,
                       @MappingTarget Shop shop);
    @Mapping(target = "id", ignore = true)
    void updateFull(ShopDTO shopDTO, @MappingTarget Shop shop);
}
