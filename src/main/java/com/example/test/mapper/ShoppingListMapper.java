package com.example.test.mapper;

import com.example.test.dto.ShoppingListDTO;
import com.example.test.entity.Customer;
import com.example.test.entity.DetailsShoppingList;
import com.example.test.entity.ShoppingList;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingListMapper {

    public ShoppingList toEntity(ShoppingListDTO shoppingListDTO) {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setName(shoppingListDTO.getNameList());
        Customer customer = new Customer();
        customer.setId(shoppingListDTO.getCustomerId());
        shoppingList.setCustomerId(customer);
        shoppingList.setRegisterDate(Calendar.getInstance());
        shoppingList.setLastUpdate(Calendar.getInstance());
        return shoppingList;
    }

    public ShoppingListDTO toDTO(ShoppingList shoppingList, List<DetailsShoppingList> detailsShoppingList) {
        ShoppingListDTO shoppingListDTO = new ShoppingListDTO();
        ItemMapper mapper = new ItemMapper();
        shoppingListDTO.setNameList(shoppingList.getName());
        shoppingListDTO.setCustomerId(shoppingList.getCustomerId().getId());
        shoppingListDTO.setItems(detailsShoppingList.stream()
                .map(mapper::map)
                .collect(Collectors.toList())
        );
        return shoppingListDTO;
    }
}
