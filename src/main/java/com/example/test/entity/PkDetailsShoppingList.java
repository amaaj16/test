package com.example.test.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class PkDetailsShoppingList implements Serializable {
    private Integer idShoppingList;
    private Integer productCode;
}
