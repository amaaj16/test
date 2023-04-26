package com.example.test.dummy;

import com.example.test.dto.DetailsShoppingListDTO;
import com.example.test.dto.ShoppingItem;
import com.example.test.dto.ShoppingListDTO;
import com.example.test.entity.Customer;
import com.example.test.entity.DetailsShoppingList;
import com.example.test.entity.Product;
import com.example.test.entity.ShoppingList;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Dummy {

    public static DetailsShoppingListDTO detailsShoppingListDTO() {

        DetailsShoppingListDTO detailsShoppingListDTO = new DetailsShoppingListDTO();
        List<ShoppingListDTO> items = new ArrayList<>();
        items.add(shoppingListDTO());
        detailsShoppingListDTO.setShoppingLists(items);
        return detailsShoppingListDTO;
    }

    public static ShoppingListDTO shoppingListDTO() {
        ShoppingListDTO shoppingListDTO = new ShoppingListDTO();
        shoppingListDTO.setNameList("TEST LIST");
        shoppingListDTO.setCustomerId(123456789);
        List<ShoppingItem> items = new ArrayList<>();
        items.add(shoppingItem());
        shoppingListDTO.setItems(items);
        return shoppingListDTO;
    }

    public static ShoppingItem shoppingItem() {
        ShoppingItem shoppingItem = new ShoppingItem();
        shoppingItem.setProductId(11);
        shoppingItem.setQuantity(5);
        return shoppingItem;
    }

    public static List<ShoppingList> listShoppingList() {
        List<ShoppingList> listShoppingList = new ArrayList<>();
        listShoppingList.add(shoppingList());
        return listShoppingList;
    }

    public static ShoppingList shoppingList() {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setIdList(1);
        shoppingList.setName("test list");
        shoppingList.setCustomerId(customer());
        shoppingList.setLastUpdate(Calendar.getInstance());
        shoppingList.setActive((byte) 1);
        shoppingList.setRegisterDate(Calendar.getInstance());
        return shoppingList;
    }

    public static DetailsShoppingList detailsShoppingList() {
        DetailsShoppingList detailsShoppingList = new DetailsShoppingList();
        detailsShoppingList.setIdShoppingList(1);
        detailsShoppingList.setShoppingList(shoppingList());
        detailsShoppingList.setProduct(product());
        detailsShoppingList.setQuantity(5);
        return detailsShoppingList;
    }

    public static List<DetailsShoppingList> listDetailsShoppingList() {
        List<DetailsShoppingList> listDetailsShoppingList = new ArrayList<>();
        listDetailsShoppingList.add(detailsShoppingList());
        return listDetailsShoppingList;
    }

    public static Customer customer() {
        Customer customer = new Customer();
        customer.setId(123456789);
        customer.setName("test customer");
        customer.setActive((byte) 1);
        return customer;
    }

    public static Product product() {
        Product product = new Product();
        product.setIdProduct(123456789);
        product.setClave("test product");
        product.setActive((byte) 1);
        product.setDescription("test description");
        return product;
    }

}
