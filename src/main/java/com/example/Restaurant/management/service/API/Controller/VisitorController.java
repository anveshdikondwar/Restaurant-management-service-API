package com.example.Restaurant.management.service.API.Controller;

import com.example.Restaurant.management.service.API.Model.Visitor;
import com.example.Restaurant.management.service.API.Service.VisitorService;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUpVisitor(@RequestBody Visitor visitor) {
        visitorService.signUpVisitor(visitor);
        return ResponseEntity.status(HttpStatus.CREATED).body("Visitor registered successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Visitor>> getAllVisitors() {
        List<Visitor> visitors = visitorService.getAllVisitors();
        return ResponseEntity.ok(visitors);
    }

    @GetMapping("/{visitorId}")
    public ResponseEntity<Visitor> getVisitorById(@PathVariable Integer visitorId) {
        Visitor visitor = visitorService.getVisitorById(visitorId);
        return ResponseEntity.ok(visitor);
    }

    @PutMapping("/{visitorId}")
    public ResponseEntity<?> updateVisitor(@PathVariable Integer visitorId, @RequestBody Visitor visitor) {
        visitorService.updateVisitor(visitorId, visitor);
        return ResponseEntity.ok("Visitor updated successfully");
    }

    @DeleteMapping("/{visitorId}")
    public ResponseEntity<?> deleteVisitor(@PathVariable Integer visitorId) {
        visitorService.deleteVisitor(visitorId);
        return ResponseEntity.ok("Visitor deleted successfully");
    }
}
