package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Product {
//제품 Entity
@Id
    @Column(length= 20 , nullable=false)
    private String ProductCode; //제품의 코드

    @Column(length = 20,nullable = false)
    private String ProductName; //제품의 이름
}
