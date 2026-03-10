package com.hostel.management.repository;

import com.hostel.management.model.Complaint;
import com.hostel.management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    List<Complaint> findByUser(User user);
    List<Complaint> findByStatus(Complaint.ComplaintStatus status);
    List<Complaint> findByUserOrderByCreatedAtDesc(User user);
}