package com.example.Restaurant.management.service.API.Repository;

import com.example.Restaurant.management.service.API.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User, Integer> {
    User findFirstByUserEmail(String newEmail);
}
