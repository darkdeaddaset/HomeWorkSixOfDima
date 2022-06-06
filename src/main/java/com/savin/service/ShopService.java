package com.savin.service;

import com.savin.dto.shop.ShopAreaAndCommissaryOnly;
import com.savin.dto.shop.ShopDTO;
import com.savin.mapper.ShopMapper;
import com.savin.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShopService {
    private final ShopRepository shopRepository;
    private final ShopMapper mapper;

    @Autowired
    public ShopService(ShopRepository shopRepository, ShopMapper mapper) {
        this.shopRepository = shopRepository;
        this.mapper = mapper;
    }

    public ShopDTO getByIdShop(long id){
        return shopRepository.findById(id)
                .map(mapper::fromShopToShopDTO)
                .orElseThrow();
    }

    public List<ShopDTO> getAllShops(){
        return shopRepository.findAll()
                .stream()
                .map(mapper::fromShopToShopDTO)
                .collect(Collectors.toList());
    }

    public ShopDTO saveShop(ShopDTO shopDTO){
        return Optional.of(shopDTO)
                .map(mapper::fromDTOToShop)
                .map(shopRepository::save)
                .map(mapper::fromShopToShopDTO)
                .orElseThrow();
    }

    public ResponseEntity updateFullShop(long id, ShopDTO shopDTO){
        return shopRepository.findById(id)
                .map(update -> { mapper.updateFull(shopDTO, update);
                    shopRepository.save(update);

                    return new ResponseEntity("Изменение внесены", HttpStatus.OK);
                }).orElseThrow();
    }

    public ResponseEntity updateShop(long id, ShopAreaAndCommissaryOnly shopAreaAndCommissaryOnly){
        return shopRepository.findById(id)
                .map(update -> { mapper.updatePartial(shopAreaAndCommissaryOnly, update);
                    shopRepository.save(update);

                    return new ResponseEntity("Изменения внесены", HttpStatus.OK);
                }).orElseThrow();
    }

    public String deleteShop(long id){
        return shopRepository.findById(id)
                .map(deleteShop -> {shopRepository.delete(deleteShop);

                    return deleteShop.getId() + ".Магазин удален: " + deleteShop.getName();
                }).orElseThrow();
    }




}
