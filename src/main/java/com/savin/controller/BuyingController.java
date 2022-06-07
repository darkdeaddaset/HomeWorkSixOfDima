package com.savin.controller;

import com.savin.dto.buying.*;
import com.savin.service.BuyingService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/buying")
public class BuyingController {

    private final BuyingService buyingService;

    @Autowired
    public BuyingController(BuyingService buyingService) {
        this.buyingService = buyingService;
    }

    @Operation(summary = "Получение заказа по id")
    @GetMapping("/{id}")
    public BuyingDTO getByIdBuying(@PathVariable(value = "id") long id){
        return buyingService.getByIdBuying(id);
    }

    @Operation(summary = "Получение всех заказов")
    @GetMapping("/all")
    public List<BuyingDTO> getAllBuying(){
        return buyingService.getAllBuying();
    }

    @Operation(summary = "Добавление заказа")
    @PostMapping("/add")
    public BuyingDTO saveBuying(@RequestBody BuyingDTO buyingDTO){
        return buyingService.saveBuying(buyingDTO);
    }

    @Operation(summary = "Полное обновление заказа")
    @PutMapping("/update/full/{id}")
    public ResponseEntity updateFullBuying(@PathVariable(value = "id") long id, @RequestBody BuyingDTO buyingDTO){
        return buyingService.updateFullBuying(id, buyingDTO);
    }

    @Operation(summary = "Частичное обновление заказа (клиент)")
    @PatchMapping("/update/customer/{id}")
    public ResponseEntity updatePartialBuying(@PathVariable(value = "id") long id,
                                              @RequestBody BuyingCustomerOnly buyingCustomerOnly){
        return buyingService.updatePartialCustomer(id, buyingCustomerOnly);
    }

    @Operation(summary = "Частичное обновление заказа (количество)")
    @PatchMapping("/update/quantity/{id}")
    public ResponseEntity updatePartialBuying(@PathVariable(value = "id") long id,
                                             @RequestBody BuyingQuantityOnly buyingQuantityOnly){
        return buyingService.updatePartialQuantity(id, buyingQuantityOnly);
    }

    @Operation(summary = "Частичное обновление заказа (магазин)")
    @PatchMapping("/update/shop/{id}")
    public ResponseEntity updatePartialBuying(@PathVariable(value = "id") long id,
                                              @RequestBody BuyingShopOnly buyingShopOnly){
        return buyingService.updatePartialShop(id, buyingShopOnly);
    }

    @Operation(summary = "Удаление заказа по id")
    @DeleteMapping("/delete/{id}")
    public String deleteBuying(@PathVariable(value = "id") long id){
        return buyingService.deleteBuying(id);
    }

    @Operation(summary = "Получение заказов с различными датами")
    @GetMapping("/all-different-date")
    public List<BuyingDateDTO> getAllDifferentDate(){
        return buyingService.getAllDifferentDate();
    }

    @Operation(summary = "Получение покупателя и магазина, где были покупки")
    @GetMapping("/history")
    public List<BuyingSurnameAndNameDTO> getHistoryOfBuying(){
        return buyingService.getHistoryOfBuying();
    }

    @Operation(summary = "Получение более подробной информации о покупке")
    @GetMapping("/history-more")
    public List<BuyingDateAndQuantityAndSurnameAndDiscountDTO> getHistoryOfBuyingMore(){
        return buyingService.getHistoryOfBuyingMore();
    }

    @Operation(summary = "Получение номер заказа, фамилию и дату (Продано на сумму не меньше 60000 руб.")
    @GetMapping("/filter-60000")
    public List<BuyingIdAndSurnameDTO> getMoreSixThousand(){
        return buyingService.getMoreSixThousand();
    }

    @Operation(summary = "Получение покупок сделанные покупателем в своем районе не ранее марта месяца")
    @GetMapping("/filter-march")
    public List<BuyingSurnameAndHomeAndDateDTO> getMarch(){
        return buyingService.getCustomerHomeBuy();
    }

    @Operation(summary = "Получение данных по покупке книг, приобретенных в районе складирования и содержащихся в запасе более 10 штук")
    @GetMapping("/get-info-book")
    public List<BuyingNameAndPriceAndStockAndQuantityDTO> getBook(){
        return buyingService.getInfoOfBook();
    }
}