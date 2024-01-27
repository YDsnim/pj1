package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {
//제품 Entity
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long RowNum; //PK

    @Column(length= 20 , nullable=false)
    private String ProductCode; //제품의 코드

    @Column(length = 20,nullable = false)
    private String ProductName; //제품의 이름

}
