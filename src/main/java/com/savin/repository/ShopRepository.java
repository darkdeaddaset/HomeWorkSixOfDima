package com.savin.repository;

import com.savin.dto.shop.ShopNameDTO;
import com.savin.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

    @Query(value = "SELECT new com.savin.dto.shop.ShopNameDTO(name) FROM Shop WHERE area = :areaFirst OR area = :areaSecond")
    List<ShopNameDTO> getArea(String areaFirst, String areaSecond);

    @Query(value = "SELECT DISTINCT new com.savin.dto.shop.ShopNameDTO(s.name) FROM Buying b JOIN Shop s ON (b.shop.id = s.id)\n" +
            "JOIN Customer c ON (b.customer.id = c.id)\n" +
            "WHERE s.area NOT LIKE CONCAT('%', :area, '%') AND c.discount >= 10 AND c.discount <= 15")
    List<ShopNameDTO> getFindShop(String area);
}
