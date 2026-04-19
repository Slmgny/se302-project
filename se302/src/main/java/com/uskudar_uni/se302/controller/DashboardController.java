package com.uskudar_uni.se302.controller;

import com.uskudar_uni.se302.model.Project;
import com.uskudar_uni.se302.model.User;
import com.uskudar_uni.se302.repository.ProjectRoleRepository;
import com.uskudar_uni.se302.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DashboardController {

    private static final Long AUTO_LOGIN_USER_ID = 2L;
    private final UserRepository userRepository;
    private final ProjectRoleRepository projectRoleRepository;

    @GetMapping({"/", "/dashboard"})
    public String dashboard(Model model) {
        User currentUser = userRepository.findById(AUTO_LOGIN_USER_ID).orElse(null);

        List<Project> projects = currentUser == null
                ? Collections.emptyList()
                : projectRoleRepository.findProjectsByUserId(AUTO_LOGIN_USER_ID);

        model.addAttribute("currentUser", currentUser);
        model.addAttribute("projects", projects);
        model.addAttribute("projectCount", projects.size());

        return "dashboard";
    }
}
