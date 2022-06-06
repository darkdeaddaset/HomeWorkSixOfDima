package com.savin.controller;

import com.savin.dto.buying.BuyingCustomerOnly;
import com.savin.dto.buying.BuyingDTO;
import com.savin.dto.buying.BuyingQuantityOnly;
import com.savin.dto.buying.BuyingShopOnly;
import com.savin.service.BuyingService;
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

    @GetMapping("/{id}")
    public BuyingDTO getByIdBuying(@PathVariable(value = "id") long id){
        return buyingService.getByIdBuying(id);
    }

    @GetMapping("/all")
    public List<BuyingDTO> getAllBuying(){
        return buyingService.getAllBuying();
    }

    @PostMapping("/add")
    public BuyingDTO saveBuying(@RequestBody BuyingDTO buyingDTO){
        return buyingService.saveBuying(buyingDTO);
    }

    @PutMapping("/update/full/{id}")
    public ResponseEntity updateFullBuying(@PathVariable(value = "id") long id, @RequestBody BuyingDTO buyingDTO){
        return buyingService.updateFullBuying(id, buyingDTO);
    }

    @PatchMapping("/update/customer/{id}")
    public ResponseEntity updatePartialBuying(@PathVariable(value = "id") long id,
                                              @RequestBody BuyingCustomerOnly buyingCustomerOnly){
        return buyingService.updatePartialCustomer(id, buyingCustomerOnly);
    }

    @PatchMapping("/update/quantity/{id}")
    public ResponseEntity updatePartialBuying(@PathVariable(value = "id") long id,
                                             @RequestBody BuyingQuantityOnly buyingQuantityOnly){
        return buyingService.updatePartialQuantity(id, buyingQuantityOnly);
    }

    @PatchMapping("/update/shop/{id}")
    public ResponseEntity updatePartialBuying(@PathVariable(value = "id") long id,
                                              @RequestBody BuyingShopOnly buyingShopOnly){
        return buyingService.updatePartialShop(id, buyingShopOnly);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBuying(@PathVariable(value = "id") long id){
        return buyingService.deleteBuying(id);
    }
}