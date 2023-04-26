package com.example.test.mapper;

import com.example.test.dto.ShoppingItem;
import com.example.test.entity.DetailsShoppingList;
import com.example.test.entity.Product;
import com.example.test.entity.ShoppingList;

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



}
