package com.example.demo.entity;

import lombok.Data;
import java.math.BigDecimal;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Table(name = "java_product_001")
@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(255) comment 'product name'", nullable = false)
    private String productName;

    @Column(columnDefinition = "decimal(10,2) comment 'product price'", nullable = false)
    private BigDecimal productPrice;
    // get, set
}
