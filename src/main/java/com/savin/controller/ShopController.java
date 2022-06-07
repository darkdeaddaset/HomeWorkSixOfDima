package com.savin.controller;

import com.savin.dto.shop.ShopAreaAndCommissaryOnly;
import com.savin.dto.shop.ShopDTO;
import com.savin.dto.shop.ShopNameDTO;
import com.savin.service.ShopService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    private ShopService shopService;

    @Autowired
    private ShopController(ShopService shopService){
        this.shopService = shopService;
    }

    @Operation(summary = "Получение магазина по id")
    @GetMapping("{id}")
    public ShopDTO searchByIdShop(@PathVariable(value = "id") long id){
        return shopService.getByIdShop(id);
    }

    @Operation(summary = "Получение всех магазинов")
    @GetMapping("/all")
    public List<ShopDTO> getShops(){
        return shopService.getAllShops();
    }

    @Operation(summary = "Добавление магазина")
    @PostMapping("/add")
    public ShopDTO addShop(@RequestBody ShopDTO shopDTO){
        return shopService.saveShop(shopDTO);
    }

    @Operation(summary = "Полное обновление магазина")
    @PutMapping("/update/full/{id}")
    public ResponseEntity updateFullShop(@PathVariable(value = "id") long id,
                                         @RequestBody ShopDTO shopDTO){
        return shopService.updateFullShop(id, shopDTO);
    }

    @Operation(summary = "Частичное обновление магазина")
    @PatchMapping("/update/{id}")
    public ResponseEntity updateShop(@PathVariable(value = "id") long id,
                                     @RequestBody ShopAreaAndCommissaryOnly shopAreaAndCommissaryOnly){
        return shopService.updateShop(id, shopAreaAndCommissaryOnly);
    }

    @Operation(summary = "Удаление магазина по id")
    @DeleteMapping("/delete/{id}")
    public String deleteShop(@PathVariable(value = "id") long id){
        return shopService.deleteShop(id);
    }

    @Operation(summary = "Получение магазинов находяшихся в указанных районах")
    @GetMapping("/area/{areaFirst}&{areaSecond}")
    public List<ShopNameDTO> getArea(@PathVariable(value = "areaFirst") String areaFirst,
                                     @PathVariable(value = "areaSecond") String areaSecond){
        return shopService.getNameFilter(areaFirst, areaSecond);
    }

    @Operation(summary = "Получение магазинов, расположенные во всех районов кроме Автозаводского и те у кого скидка 10-15%")
    @GetMapping("/filter-area")
    public List<ShopNameDTO> getFindShop(){
        return shopService.getFindShop();
    }
}
