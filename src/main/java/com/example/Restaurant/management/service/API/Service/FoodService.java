package com.example.Restaurant.management.service.API.Service;

import com.example.Restaurant.management.service.API.Model.Food;
import com.example.Restaurant.management.service.API.Repository.IFoodRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    private IFoodRepo foodRepo;

    public Food createFood(Food food) {
        // Implement food creation logic
        return foodRepo.save(food);
    }

    public Food updateFood(Integer foodId, Food updatedFood) {
        Food existingFood = foodRepo.findById(foodId)
                .orElseThrow(() -> new EntityNotFoundException("Food not found"));

        // Update food fields based on your requirements
        existingFood.setFoodTitle(updatedFood.getFoodTitle());
        existingFood.setFoodDesc(updatedFood.getFoodDesc());
        existingFood.setFoodType(updatedFood.getFoodType());
        // Update other fields as needed

        return foodRepo.save(existingFood);
    }

    public void deleteFood(Integer foodId) {
        Food existingFood = foodRepo.findById(foodId)
                .orElseThrow(() -> new EntityNotFoundException("Food not found"));

        foodRepo.delete(existingFood);
    }

    public Food getFoodById(Integer foodId) {
        return foodRepo.findById(foodId)
                .orElseThrow(() -> new EntityNotFoundException("Food not found"));
    }

    public List<Food> getAllFoodItems() {
        return foodRepo.findAll();
    }
}
