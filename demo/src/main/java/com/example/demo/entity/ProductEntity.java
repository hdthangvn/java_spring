package com.example.demo.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.*;

@Table(name = "java_product_001")
@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    private BigDecimal productPrice;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "java_product_order_001", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))

    private List<OrderEntity> orders;

    // get, set
}
