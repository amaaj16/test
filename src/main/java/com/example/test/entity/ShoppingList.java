package com.example.test.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "lista_compras")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_List",columnDefinition = "int")
    private Integer idList;

    @ManyToOne
    @JoinColumn(name ="id_cliente")
    private  Customer customerId;

    @Column(name = "nombre")
    private String name;
    @Column(name = "fecha_registro")
    private Calendar registerDate;
    @Column(name = "fecha_ultima_actualizacion")
    private Calendar lastUpdate;
    @Column(name = "activo")
    private byte active;


}
