package com.example.test.service;

import com.example.test.dto.DetailsShoppingListDTO;
import com.example.test.entity.DetailsShoppingList;

import java.util.List;

public interface ShoppingService {

    List<DetailsShoppingList> addList(DetailsShoppingListDTO shoppingListDTO);

    List<DetailsShoppingListDTO> getList(int idCustomer);

    DetailsShoppingListDTO updateShoppingList(DetailsShoppingListDTO shoppingList);

    int deleteList(int ShoppingListId);
}
