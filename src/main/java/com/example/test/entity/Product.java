package com.example.test.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PRODUCTOS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {


    @Id
    @Column(name = "ID_PRODUCTO", nullable = false,columnDefinition = "int")
    private Integer idProduct;

    @Column(name = "CLAVE", nullable = false,columnDefinition = "varchar(15)")
    private String clave;


    @Column(name = "DESCRIPCION", columnDefinition = "varchar(150)")
    private String description;

    @Column(name = "ACTIVO",columnDefinition = "bit")
    private byte active;


}
