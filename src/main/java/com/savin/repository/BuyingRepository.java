package com.savin.repository;

import com.savin.dto.buying.*;
import com.savin.model.Buying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyingRepository extends JpaRepository<Buying, Long> {

    @Query(value = "SELECT DISTINCT new com.savin.dto.buying.BuyingDateDTO(date) FROM Buying ")
    List<BuyingDateDTO> getAllDifferentDates();

    @Query(value = "SELECT new com.savin.dto.buying.BuyingSurnameAndNameDTO(c.surname, s.name) FROM Buying b JOIN Customer c ON (b.customer.id = c.id)" +
            "JOIN Shop s ON (b.shop.id = s.id)")
    List<BuyingSurnameAndNameDTO> getHistoryOfBuying();

    @Query(value = "SELECT new com.savin.dto.buying.BuyingDateAndQuantityAndSurnameAndDiscountDTO(b.date, b.quantity, c.surname, c.discount, s.name ) " +
            "FROM Buying b JOIN Customer  c ON (b.customer.id = c.id)\n" +
            "JOIN Shop s ON (b.shop.id = s.id)")
    List<BuyingDateAndQuantityAndSurnameAndDiscountDTO> getHistoryOfBuyingMore();

    @Query(value = "SELECT new com.savin.dto.buying.BuyingIdAndSurnameDTO(b.id, c.surname, b.date)" +
            " FROM Buying b JOIN Customer c ON (b.customer.id = c.id) WHERE b.price > 60000")
    List<BuyingIdAndSurnameDTO> MoreSixThousand();

    @Query(value = "SELECT c.surname, c.home, b.date FROM Buying b " +
            "JOIN Customer c ON (b.customer.id = c.id) \n" +
            "JOIN Shop s ON (b.shop.id = s.id) \n" +
            "WHERE c.home = s.area AND b.date >= '2022-04-01'")
    List<BuyingSurnameAndHomeAndDateDTO> getBuyingMarch();

    @Query(value = "SELECT bo.name, b.price, bo.stock, b.quantity FROM Buying b JOIN Shop s ON (b.shop.id = s.id)\n" +
            "JOIN Books bo ON (b.books.id = bo.id)\n" +
            "WHERE s.area = bo.stock AND bo.count > 10\n" +
            "ORDER BY bo.count")
    List<BuyingNameAndPriceAndStockAndQuantityDTO> getInfoOfBook();
}
