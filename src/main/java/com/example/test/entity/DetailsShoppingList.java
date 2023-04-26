package com.example.test.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lista_compra_detalle")
public class DetailsShoppingList implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idLista", nullable = false,columnDefinition = "int")
    private Integer idShoppingList;


    @Column(name = "codigo_producto",nullable = false,columnDefinition = "int")
    private Integer productCode;

    @ManyToOne()
    @JoinColumn(name = "id_lista_compra",nullable = false)
    private ShoppingList shoppingList;

    @ManyToOne
    @JoinColumn(name = "product_id_producto", nullable = false)
    private Product product;

    @Column(name = "cantidad", columnDefinition = "int")
    private int quantity;

}
