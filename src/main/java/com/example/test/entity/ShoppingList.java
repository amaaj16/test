package com.example.test.entity;


import lombok.Data;
import lombok.NoArgsConstructor;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "lista_compras")
@Data
@NoArgsConstructor
public class ShoppingList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idLista",columnDefinition = "int")
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
