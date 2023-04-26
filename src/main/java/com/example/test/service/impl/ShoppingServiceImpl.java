package com.example.test.service.impl;

import com.example.test.dto.DetailsShoppingListDTO;
import com.example.test.dto.ShoppingListDTO;
import com.example.test.entity.DetailsShoppingList;
import com.example.test.entity.ShoppingList;
import com.example.test.mapper.DetailsShoppingListMapper;
import com.example.test.mapper.ShoppingListMapper;
import com.example.test.repository.DetailsShoppingListRepository;
import com.example.test.repository.ShoppingListRepository;
import com.example.test.service.ShoppingService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShoppingServiceImpl implements ShoppingService {

    private static final Logger log = LoggerFactory.getLogger(ShoppingServiceImpl.class);
    private final ShoppingListRepository shoppingListRepository;

    private final DetailsShoppingListRepository detailsShoppingListRepository;


    @Override
    @Transactional
    public List<DetailsShoppingList> addList(DetailsShoppingListDTO detailsShoppingListDTO) {
        ShoppingListMapper mapper = new ShoppingListMapper();
        DetailsShoppingListMapper detailsMapper = new DetailsShoppingListMapper();
        return detailsShoppingListDTO.getShoppingLists().stream()/*.map(item -> {
            customerRepository.findById(item.getCustomerId()).orElse(customerRepository.save(new Customer(item.getCustomerId(), "test", (byte) 1)));
            item.getItems().stream().map(subItem -> {
                return productRepository.findById(subItem.getProductId()).orElse(productRepository.save(new Product(subItem.getProductId(), "testProduct", "producto", (byte) 1)));
            });
            return item;
        })*/.map(item -> {
            ShoppingList listSaved = shoppingListRepository.save(mapper.toEntity(item));
            return item.getItems().stream()
                    .map(subItem -> detailsMapper.toEntity(listSaved.getIdList(), subItem))
                    .map(detailsShoppingListRepository::save).collect(Collectors.toList()).get(0);

        }).collect(Collectors.toList());


    }

    @Override
    public DetailsShoppingListDTO getList(int idCustomer) {
        ShoppingListMapper shoppingListMapper = new ShoppingListMapper();
        DetailsShoppingListDTO detailsShoppingListDTO = new DetailsShoppingListDTO();
        List<ShoppingList> shoppingList = shoppingListRepository.findShoppingListByCustomerId(idCustomer);
        if (shoppingList.isEmpty()) {
            return null;
        }
        List<ShoppingListDTO> result = shoppingList.stream().map(item -> {
            List<DetailsShoppingList> products = detailsShoppingListRepository.findByShoppingList(item.getIdList());
            return shoppingListMapper.toDTO(item, products);
        }).collect(Collectors.toList());

        detailsShoppingListDTO.setShoppingLists(result);
        return detailsShoppingListDTO;
    }

    @Override
    @Transactional
    public DetailsShoppingListDTO updateShoppingList(DetailsShoppingListDTO shoppingListDTO, int idList) {
        DetailsShoppingListMapper detailsMapper = new DetailsShoppingListMapper();
        List<ShoppingList> result = shoppingListRepository.findShoppingListByIdList(idList);
        if (result.isEmpty()) {
            return null;
        }
        result.forEach(item -> {
            item.setName(shoppingListDTO.getShoppingLists().get(0).getNameList());
            item.setLastUpdate(Calendar.getInstance());
            shoppingListRepository.save(item);
        });
        shoppingListDTO.getShoppingLists().stream()
                .map(item -> item.getItems().stream()
                        .map(subItem -> detailsMapper.toEntity(idList, subItem))
                        .map(detailsShoppingListRepository::save).collect(Collectors.toList()).get(0));

        return shoppingListDTO;

    }

    @Override
    @Transactional
    public int deleteList(int ShoppingListId) {
        try {
            detailsShoppingListRepository.deleteByShoppingList(ShoppingListId);
            shoppingListRepository.deleteShoppingListByShoppingListId(ShoppingListId);
        } catch (Exception e) {
            log.error(e.getMessage());
            return 0;
        }
        List<ShoppingList> list = shoppingListRepository.findShoppingListByIdList(ShoppingListId);
        if (!list.isEmpty()) {
            return 0;
        }

        return 1;
    }
}
