package com.tech.the_gadget_grid.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LocalDateTime orderDate;

    @Column(nullable = false)
    private Double totalAmount;

    private String paymentStatus; // Paid, Pending

    private String orderStatus; // Processing, Shipped, Delivered

    @PrePersist
    protected void onCreate() {
        this.orderDate = LocalDateTime.now();
        if (this.orderStatus == null) this.orderStatus = "Processing";
        if (this.paymentStatus == null) this.paymentStatus = "Pending";
    }
}