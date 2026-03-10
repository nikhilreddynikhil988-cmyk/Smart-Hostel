package com.hostel.management.service;

import com.hostel.management.model.Staff;
import com.hostel.management.model.User;
import com.hostel.management.repository.StaffRepository;
import com.hostel.management.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminService {

    private final UserRepository userRepository;
    private final StaffRepository staffRepository;

    public AdminService(UserRepository userRepository,
                        StaffRepository staffRepository) {
        this.userRepository = userRepository;
        this.staffRepository = staffRepository;
    }

    public List<User> getAllStudents() {
        return userRepository.findAll().stream()
                .filter(u -> u.getRole() == User.Role.STUDENT)
                .toList();
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Staff addStaff(Staff staff) {
        if (staffRepository.existsByEmail(staff.getEmail())) {
            throw new RuntimeException("Staff with this email already exists");
        }
        return staffRepository.save(staff);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }
}