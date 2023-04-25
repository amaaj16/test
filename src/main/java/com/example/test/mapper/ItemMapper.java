package com.example.test.mapper;

import com.example.test.dto.ShoppingItem;
import com.example.test.entity.DetailsShoppingList;

public class ItemMapper {

    public ShoppingItem map(DetailsShoppingList detailsShoppingList) {
        ShoppingItem item = new ShoppingItem();
        item.setProductId(detailsShoppingList.getProduct().getIdProduct());
        item.setQuantity(detailsShoppingList.getQuantity());
        return item;
    }
}
