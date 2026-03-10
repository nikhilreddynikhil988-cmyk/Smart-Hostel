package com.hostel.management.service;

import com.hostel.management.dto.ComplaintRequest;
import com.hostel.management.model.Complaint;
import com.hostel.management.model.User;
import com.hostel.management.repository.ComplaintRepository;
import com.hostel.management.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComplaintService {

    private final ComplaintRepository complaintRepository;
    private final UserRepository userRepository;

    public ComplaintService(ComplaintRepository complaintRepository,
                            UserRepository userRepository) {
        this.complaintRepository = complaintRepository;
        this.userRepository = userRepository;
    }

    public Complaint submitComplaint(ComplaintRequest request, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Complaint complaint = Complaint.builder()
                .user(user)
                .title(request.getTitle())
                .description(request.getDescription())
                .category(request.getCategory())
                .build();

        return complaintRepository.save(complaint);
    }

    public List<Complaint> getMyComplaints(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return complaintRepository.findByUserOrderByCreatedAtDesc(user);
    }

    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    public Complaint updateStatus(Long id, String status) {
        Complaint complaint = complaintRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));
        complaint.setStatus(Complaint.ComplaintStatus.valueOf(status.toUpperCase()));
        return complaintRepository.save(complaint);
    }
}