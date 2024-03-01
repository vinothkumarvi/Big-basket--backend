package com.product.product.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long productid;

    @Column(name = "SKU", nullable = false)
    private String sku;

    @Column(name = " Name", nullable = false, length = 24)
    private String name;

    @Column(name = "Price", precision = 10, scale = 2, nullable = false)
    private Long price;

    @Column(name = "ShortName", nullable = false, length = 20)
    private String shortName;

    @Column(name = "Description", nullable = false, length = 100)
    private String Description;

    @Column(name = "CreationDate", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "Delivary Tim Span", nullable = false)
    private String deliveryTimeSpan;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryName")
    private Category category;

    @Column(name = "ImageURL", nullable = true)
    private String imageUrl;

}
