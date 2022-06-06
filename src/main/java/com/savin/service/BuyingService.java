package com.savin.service;

import com.savin.dto.buying.BuyingCustomerOnly;
import com.savin.dto.buying.BuyingDTO;
import com.savin.dto.buying.BuyingQuantityOnly;
import com.savin.dto.buying.BuyingShopOnly;
import com.savin.mapper.BuyingMapper;
import com.savin.repository.BuyingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BuyingService {
    private final BuyingMapper mapper;
    private final BuyingRepository buyingRepository;

    @Autowired
    public BuyingService(BuyingMapper mapper, BuyingRepository buyingRepository) {
        this.mapper = mapper;
        this.buyingRepository = buyingRepository;
    }

    public BuyingDTO getByIdBuying(long id){
        return buyingRepository.findById(id)
                .map(mapper::fromBuyingToDTO)
                .orElseThrow();
    }

    public List<BuyingDTO> getAllBuying(){
        return buyingRepository.findAll()
                .stream()
                .map(mapper::fromBuyingToDTO)
                .collect(Collectors.toList());
    }

    public BuyingDTO saveBuying(BuyingDTO buyingDTO){
        return Optional.of(buyingDTO)
                .map(mapper::fromDTOToBuying)
                .map(buyingRepository::save)
                .map(mapper::fromBuyingToDTO)
                .orElseThrow();
    }

    public ResponseEntity updateFullBuying(long id, BuyingDTO buyingDTO){
        return buyingRepository.findById(id)
                .map(update -> { mapper.updateFull(buyingDTO, update);
                    buyingRepository.save(update);

                    return new ResponseEntity("Изменения внесены", HttpStatus.OK);
                }).orElseThrow();
    }

    public ResponseEntity updatePartialShop(long id, BuyingShopOnly buyingShopOnly){
        return buyingRepository.findById(id)
                .map(updateShop -> { mapper.updatePartialShop(buyingShopOnly, updateShop);
                    buyingRepository.save(updateShop);

                    return new ResponseEntity("Магазин изменен на " + updateShop.getShop().getName(), HttpStatus.OK);
                }).orElseThrow();
    }

    public ResponseEntity updatePartialCustomer(long id, BuyingCustomerOnly buyingCustomerOnly){
        return buyingRepository.findById(id)
                .map(updateCustomer -> { mapper.updatePartialCustomer(buyingCustomerOnly, updateCustomer);
                    buyingRepository.save(updateCustomer);

                    return new ResponseEntity("Покупатель изменен на " + updateCustomer.getCustomer().getSurname(), HttpStatus.OK);
                }).orElseThrow();
    }

    public ResponseEntity updatePartialQuantity(long id, BuyingQuantityOnly buyingQuantityOnly){
        return buyingRepository.findById(id)
                .map(updateQuantity -> { mapper.updatePartialQuantity(buyingQuantityOnly, updateQuantity);
                    buyingRepository.save(updateQuantity);

                    return new ResponseEntity("Количество изменено: " + updateQuantity.getQuantity(), HttpStatus.OK);
                }).orElseThrow();
    }

    public String deleteBuying(long id){
        return buyingRepository.findById(id)
                .map(delete -> { buyingRepository.delete(delete);

                    return delete.getId() + ".Покупка удалена: " + delete.getCustomer().getSurname();
                }).orElseThrow();
    }
}
