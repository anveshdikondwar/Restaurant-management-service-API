package com.example.Restaurant.management.service.API.Model;

import com.example.Restaurant.management.service.API.Enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private Integer orderQuantity;
    private OrderStatus orderStatus;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "fk_food_Id")
    private Food food;

    @ManyToOne
    @JoinColumn(name = "fk_user_Id")
    private User customer;
}
