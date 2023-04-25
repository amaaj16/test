package com.example.test.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "Clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {

    @Id
    @Column(name = "id_cliente",nullable = false, columnDefinition = "int")
    private Integer id;

    @Column(name = "nombre",nullable = false,columnDefinition = "varchar(50)")
    private String name;
    @Column(name = "activo",columnDefinition = "bit default 1")
    private Byte active;


}
