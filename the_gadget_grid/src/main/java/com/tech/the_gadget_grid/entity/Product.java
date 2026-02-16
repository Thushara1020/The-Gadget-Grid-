package com.tech.the_gadget_grid.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column
    private String productName;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String category;

    @Column
    private Double price;

    @Column
    private Integer stockQuantity;

    private String imageUrl;

    private String productBrand;
}