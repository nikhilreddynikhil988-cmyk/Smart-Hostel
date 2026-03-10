package com.hostel.management.controller;

import com.hostel.management.dto.ComplaintRequest;
import com.hostel.management.model.Complaint;
import com.hostel.management.service.ComplaintService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @PostMapping
    public ResponseEntity<Complaint> submit(@Valid @RequestBody ComplaintRequest request,
                                            Authentication auth) {
        return ResponseEntity.ok(complaintService.submitComplaint(request, auth.getName()));
    }

    @GetMapping("/my")
    public ResponseEntity<List<Complaint>> myComplaints(Authentication auth) {
        return ResponseEntity.ok(complaintService.getMyComplaints(auth.getName()));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Complaint>> allComplaints() {
        return ResponseEntity.ok(complaintService.getAllComplaints());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Complaint> updateStatus(@PathVariable Long id,
                                                   @RequestParam String status) {
        return ResponseEntity.ok(complaintService.updateStatus(id, status));
    }
}