package com.example.test.mapper;

import com.example.test.dto.ShoppingListDTO;
import com.example.test.entity.Customer;
import com.example.test.entity.ShoppingList;

import java.util.Calendar;

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
}
