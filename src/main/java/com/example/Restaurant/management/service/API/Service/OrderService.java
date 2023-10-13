package com.example.Restaurant.management.service.API.Service;

import com.example.Restaurant.management.service.API.Model.Order;
import com.example.Restaurant.management.service.API.Repository.IOrderRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private IOrderRepo orderRepo;

    public Order createOrder(Order order) {
        // Implement order creation logic
        return orderRepo.save(order);
    }

    public Order updateOrder(Integer orderId, Order updatedOrder) {
        Order existingOrder = orderRepo.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));

        // Update order fields based on your requirements
        existingOrder.setOrderQuantity(updatedOrder.getOrderQuantity());
        existingOrder.setOrderStatus(updatedOrder.getOrderStatus());
        // Update other fields as needed

        return orderRepo.save(existingOrder);
    }

    public void deleteOrder(Integer orderId) {
        Order existingOrder = orderRepo.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));

        orderRepo.delete(existingOrder);
    }

    public Order getOrderById(Integer orderId) {
        return orderRepo.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
}

