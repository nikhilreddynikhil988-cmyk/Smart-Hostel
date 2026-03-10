package com.hostel.management.controller;

import com.hostel.management.model.Staff;
import com.hostel.management.model.User;
import com.hostel.management.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<User>> getStudents() {
        return ResponseEntity.ok(adminService.getAllStudents());
    }

    @GetMapping("/staff")
    public ResponseEntity<List<Staff>> getStaff() {
        return ResponseEntity.ok(adminService.getAllStaff());
    }

    @PostMapping("/staff")
    public ResponseEntity<Staff> addStaff(@RequestBody Staff staff) {
        return ResponseEntity.ok(adminService.addStaff(staff));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        adminService.deleteUser(id);
        return ResponseEntity.ok("Student deleted successfully");
    }

    @DeleteMapping("/staff/{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable Long id) {
        adminService.deleteStaff(id);
        return ResponseEntity.ok("Staff deleted successfully");
    }
}