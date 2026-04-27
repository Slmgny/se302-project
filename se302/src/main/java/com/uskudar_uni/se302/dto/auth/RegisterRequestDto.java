package com.uskudar_uni.se302.dto.auth;

import com.uskudar_uni.se302.model.enums.UserType;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequestDto {

    @NotBlank(message = "Full name is required")
    @Size(max = 120, message = "Full name must be at most 120 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    @Size(max = 120, message = "Email must be at most 120 characters")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 72, message = "Password must be between 8 and 72 characters")
    private String password;

    @NotBlank(message = "Password confirmation is required")
    private String confirmPassword;

    @NotNull(message = "User type is required")
    private UserType userType;

    @Size(max = 150, message = "University must be at most 150 characters")
    private String university;

    @Size(max = 150, message = "Department must be at most 150 characters")
    private String department;

    @Size(max = 150, message = "Title must be at most 150 characters")
    private String title;

    @Min(value = 1, message = "Academic year must be at least 1")
    @Max(value = 8, message = "Academic year must be at most 8")
    private Integer year;

    @AssertTrue(message = "Password and confirmation must match")
    public boolean isPasswordConfirmed() {
        if (password == null || confirmPassword == null) {
            return false;
        }
        return password.equals(confirmPassword);
    }
}
