package com.uskudar_uni.se302.controller;

import com.uskudar_uni.se302.dto.auth.LoginRequestDto;
import com.uskudar_uni.se302.dto.auth.RegisterRequestDto;
import com.uskudar_uni.se302.exception.EmailAlreadyExistsException;
import com.uskudar_uni.se302.model.enums.UserType;
import com.uskudar_uni.se302.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @ModelAttribute("userTypes")
    public UserType[] userTypes() {
        return UserType.values();
    }

    @GetMapping("/login")
    public String loginPage(
            @RequestParam(name = "error", required = false) Boolean error,
            @RequestParam(name = "logout", required = false) Boolean logout,
            Model model
    ) {
        if (!model.containsAttribute("loginRequest")) {
            model.addAttribute("loginRequest", new LoginRequestDto());
        }

        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("errorMessage", "Invalid email or password");
        }

        if (Boolean.TRUE.equals(logout)) {
            model.addAttribute("successMessage", "You have been signed out successfully");
        }

        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        if (!model.containsAttribute("registerRequest")) {
            model.addAttribute("registerRequest", new RegisterRequestDto());
        }
        return "register";
    }

    @GetMapping("/forgot-password")
    public String forgotPasswordPage() {
        return "forgot-password";
    }

    @PostMapping("/register")
    public String register(
            @Valid @ModelAttribute("registerRequest") RegisterRequestDto registerRequest,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
                return "register";
        }

        try {
            authService.register(registerRequest);
            redirectAttributes.addFlashAttribute("successMessage", "Registration completed. Please sign in.");
            return "redirect:/auth/login";
        } catch (EmailAlreadyExistsException ex) {
            bindingResult.rejectValue("email", "email.exists", ex.getMessage());
            model.addAttribute("registerRequest", registerRequest);
            return "register";
        }
    }
}
