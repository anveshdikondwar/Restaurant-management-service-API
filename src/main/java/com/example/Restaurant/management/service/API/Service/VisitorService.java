package com.example.Restaurant.management.service.API.Service;

import com.example.Restaurant.management.service.API.DTO.SignUpOutput;
import com.example.Restaurant.management.service.API.Model.Visitor;
import com.example.Restaurant.management.service.API.Repository.IVisitorRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorService {
    @Autowired
    private IVisitorRepo visitorRepo;

    public SignUpOutput signUpVisitor(Visitor visitor) {
        // Add validation logic if needed
        visitorRepo.save(visitor);
        return new SignUpOutput(true, "Visitor registered successfully");
    }

    public List<Visitor> getAllVisitors() {
        return visitorRepo.findAll();
    }

    public Visitor getVisitorById(Integer visitorId) {
        return visitorRepo.findById(visitorId)
                .orElseThrow(() -> new EntityNotFoundException("Visitor not found with ID: " + visitorId));
    }

    public void updateVisitor(Integer visitorId, Visitor visitor) {
        Visitor existingVisitor = getVisitorById(visitorId);
        // Update visitor properties as needed
        visitorRepo.save(existingVisitor);
    }

    public void deleteVisitor(Integer visitorId) {
        Visitor visitor = getVisitorById(visitorId);
        visitorRepo.delete(visitor);
    }
}
