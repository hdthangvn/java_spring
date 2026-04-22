package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "java_order_001")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int userId;

    @ManyToMany(mappedBy = "orders")
    @ToString.Exclude
    private List<ProductEntity> productsList;
}
