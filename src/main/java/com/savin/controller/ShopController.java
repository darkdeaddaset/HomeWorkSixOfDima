package com.savin.controller;

import com.savin.dto.shop.ShopAreaAndCommissaryOnly;
import com.savin.dto.shop.ShopDTO;
import com.savin.service.ShopService;
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

    @GetMapping("{id}")
    public ShopDTO searchByIdShop(@PathVariable(value = "id") long id){
        return shopService.getByIdShop(id);
    }

    @GetMapping("/all")
    public List<ShopDTO> getShops(){
        return shopService.getAllShops();
    }

    @PostMapping("/add")
    public ShopDTO addShop(@RequestBody ShopDTO shopDTO){
        return shopService.saveShop(shopDTO);
    }

    @PutMapping("/update/full/{id}")
    public ResponseEntity updateFullShop(@PathVariable(value = "id") long id,
                                         @RequestBody ShopDTO shopDTO){
        return shopService.updateFullShop(id, shopDTO);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity updateShop(@PathVariable(value = "id") long id,
                                     @RequestBody ShopAreaAndCommissaryOnly shopAreaAndCommissaryOnly){
        return shopService.updateShop(id, shopAreaAndCommissaryOnly);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteShop(@PathVariable(value = "id") long id){
        return shopService.deleteShop(id);
    }


}
