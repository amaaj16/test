package com.example.test.mapper;

import com.example.test.dto.DetailsShoppingListDTO;
import com.example.test.dto.ShoppingItem;
import com.example.test.dto.ShoppingListDTO;
import com.example.test.entity.DetailsShoppingList;
import com.example.test.entity.Product;
import com.example.test.entity.ShoppingList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetailsShoppingListMapper {

    public DetailsShoppingList toEntity(Integer idList, ShoppingItem shoppingItem) {

        DetailsShoppingList detailsShoppingList = new DetailsShoppingList();
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setIdList(idList);
        detailsShoppingList.setShoppingList(shoppingList);
        detailsShoppingList.setIdShoppingList(idList);
        detailsShoppingList.setQuantity(shoppingItem.getQuantity());
        detailsShoppingList.setProductCode(shoppingItem.getProductId());
        Product product = new Product();
        product.setIdProduct(shoppingItem.getProductId());
        detailsShoppingList.setProduct(product);
        return detailsShoppingList;
    }

    public DetailsShoppingListDTO toDTO(ShoppingList shoppingListEntity, List<DetailsShoppingList> detailsShoppingList) {
        DetailsShoppingListDTO detailsShoppingListDTO = new DetailsShoppingListDTO();
        ItemMapper mapper = new ItemMapper();
        ShoppingListDTO shoppingListDTO = new ShoppingListDTO();
        shoppingListDTO.setNameList(shoppingListEntity.getName());
        shoppingListDTO.setCustomerId(shoppingListEntity.getCustomerId().getId());

        shoppingListDTO.setItems(detailsShoppingList.stream()
                .map(mapper::map)
                .collect(Collectors.toList())
        );
        List<ShoppingListDTO> list = new ArrayList<>();
        list.add(shoppingListDTO);
        detailsShoppingListDTO.setList(list);


        return detailsShoppingListDTO;
    }
}
