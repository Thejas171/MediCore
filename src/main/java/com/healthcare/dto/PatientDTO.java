package com.healthcare.dto;

import jakarta.validation.constraints.*;

public class PatientDTO {

    private Long id;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name max length is 100")
    private String name;

    @Email(message = "Invalid email format")
    @Size(max = 100)
    private String email;

    @Pattern(regexp = "^[0-9]{10,15}$", message = "Phone should be 10-15 digits")
    private String phone;

    @NotNull(message = "Age is required")
    @Min(value = 0, message = "Age cannot be negative")
    private Integer age;

    @NotBlank(message = "Gender is required")
    private String gender;

    public PatientDTO() {}

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
}
