package com.example.Restaurant.management.service.API.Repository;

import com.example.Restaurant.management.service.API.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo extends JpaRepository<Admin, Integer> {
    Admin findFirstByAdminEmail(String email);
}
