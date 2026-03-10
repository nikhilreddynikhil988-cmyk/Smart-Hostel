package com.hostel.management.dto;

import jakarta.validation.constraints.NotBlank;

public class ComplaintRequest {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    private String category;

    // ✅ Getters
    public String getTitle()        { return title; }
    public String getDescription()  { return description; }
    public String getCategory()     { return category; }

    // ✅ Setters
    public void setTitle(String title)             { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setCategory(String category)       { this.category = category; }
}