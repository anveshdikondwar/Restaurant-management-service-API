package com.example.Restaurant.management.service.API.Model;

import com.example.Restaurant.management.service.API.Enums.FoodType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer foodId;
    private String foodTitle;
    private String foodDesc;
    @Enumerated(EnumType.STRING)
    private FoodType foodType;
    private String foodImg;
    private Double foodPrice;
    private LocalDateTime createdAt;
}
