package com.healthcare.dto;

import jakarta.validation.constraints.*;

public class DoctorDTO {

    private Long id;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name max length is 100")
    private String name;

    @NotBlank(message = "Specialization is required")
    @Size(max = 100)
    private String specialization;

    @Pattern(regexp = "^[0-9]{10,15}$", message = "Phone should be 10-15 digits")
    private String phone;

    @Email(message = "Invalid email format")
    @Size(max = 100)
    private String email;

    public DoctorDTO() {}

    // getters & setters...
    public Long getId() { 
    	return id; 
    }
    public void setId(Long id) { 
    	this.id = id; 
    }

    public String getName() { 
    	return name; 
    }
    public void setName(String name) { 
    	this.name = name; 
    }

    public String getSpecialization() { 
    	return specialization; 
    }
    public void setSpecialization(String specialization) { 
    	this.specialization = specialization; 
    }

    public String getPhone() { 
    	return phone; 
    }
    public void setPhone(String phone) { 
    	this.phone = phone; 
    }

    public String getEmail() { 
    	return email; 
    }
    public void setEmail(String email) {
    	this.email = email; 
    }
}
