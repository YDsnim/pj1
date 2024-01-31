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
public class Product { //제품

    @Id
    @Column(length = 20, nullable = false)
    private String ProductCode; //

    @Column(length = 20 ,nullable = false)
    private String ProductName; //

}