package com.healthcare.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class StatusDTO {
    @NotBlank(message = "Status is required")
    @Size(max = 50)
    private String status;

    public StatusDTO() {}

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
