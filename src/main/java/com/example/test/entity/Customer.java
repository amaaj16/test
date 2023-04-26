package com.example.test.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "CLIENTES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    @Id
    @Column(name = "ID_CLIENTE",nullable = false, columnDefinition = "int")
    private Integer id;

    @Column(name = "NOMBRE",nullable = false,columnDefinition = "varchar(50)")
    private String name;
    @Column(name = "ACTIVO",columnDefinition = "bit default 1")
    private Byte active;


}
