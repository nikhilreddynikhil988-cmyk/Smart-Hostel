package com.hostel.management.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private String phone;
    private String designation;
    private String department;

    @Column(updatable = false)
    private LocalDateTime joinedAt;

    @PrePersist
    protected void onCreate() {
        joinedAt = LocalDateTime.now();
    }

    // ✅ Constructors
    public Staff() {}

    public Staff(Long id, String name, String email, String phone,
                 String designation, String department, LocalDateTime joinedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.designation = designation;
        this.department = department;
        this.joinedAt = joinedAt;
    }

    // ✅ Getters
    public Long getId()                 { return id; }
    public String getName()             { return name; }
    public String getEmail()            { return email; }
    public String getPhone()            { return phone; }
    public String getDesignation()      { return designation; }
    public String getDepartment()       { return department; }
    public LocalDateTime getJoinedAt()  { return joinedAt; }

    // ✅ Setters
    public void setId(Long id)                        { this.id = id; }
    public void setName(String name)                  { this.name = name; }
    public void setEmail(String email)                { this.email = email; }
    public void setPhone(String phone)                { this.phone = phone; }
    public void setDesignation(String designation)    { this.designation = designation; }
    public void setDepartment(String department)      { this.department = department; }
    public void setJoinedAt(LocalDateTime joinedAt)   { this.joinedAt = joinedAt; }

    // ✅ Builder
    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Long id;
        private String name, email, phone, designation, department;
        private LocalDateTime joinedAt;

        public Builder id(Long id)                   { this.id = id; return this; }
        public Builder name(String name)             { this.name = name; return this; }
        public Builder email(String email)           { this.email = email; return this; }
        public Builder phone(String phone)           { this.phone = phone; return this; }
        public Builder designation(String d)         { this.designation = d; return this; }
        public Builder department(String d)          { this.department = d; return this; }

        public Staff build() {
            return new Staff(id, name, email, phone, designation, department, joinedAt);
        }
    }
}