package com.example.test.dto;

import lombok.*;

import java.util.List;

@Data
public class ShoppingListDTO {

    private Integer customerId;

    private String NameList;

    private List<ShoppingItem> items;


}
