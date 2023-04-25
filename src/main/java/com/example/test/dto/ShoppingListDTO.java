package com.example.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingListDTO {

    private Integer customerId;

    private String NameList;

    private List<ShoppingItem> items;


}
