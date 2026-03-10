package com.hostel.management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    private String phone;
    private String roomNumber;
    private String role;

    // ✅ Getters
    public String getName()        { return name; }
    public String getEmail()       { return email; }
    public String getPassword()    { return password; }
    public String getPhone()       { return phone; }
    public String getRoomNumber()  { return roomNumber; }
    public String getRole()        { return role; }

    // ✅ Setters
    public void setName(String name)               { this.name = name; }
    public void setEmail(String email)             { this.email = email; }
    public void setPassword(String password)       { this.password = password; }
    public void setPhone(String phone)             { this.phone = phone; }
    public void setRoomNumber(String roomNumber)   { this.roomNumber = roomNumber; }
    public void setRole(String role)               { this.role = role; }
}