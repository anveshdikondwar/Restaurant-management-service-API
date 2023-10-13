package com.example.Restaurant.management.service.API.Repository;

import com.example.Restaurant.management.service.API.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepo extends JpaRepository<Order, Integer> {
}
