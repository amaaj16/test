package com.example.test.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {


    @Id
    @Column(name = "id_product", nullable = false,columnDefinition = "int")
    private Integer idProduct;

    @Column(name = "clave", nullable = false,columnDefinition = "varchar(15)")
    private String clave;


    @Column(name = "descripcion", nullable = true,columnDefinition = "varchar(150)")
    private String description;

    @Column(name = "activo",columnDefinition = "bit")
    private byte active;


}
