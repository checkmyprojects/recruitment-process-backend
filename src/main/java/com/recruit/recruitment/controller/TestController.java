package com.recruit.recruitment.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('PEOPLE') or hasRole('BUSINESS') or hasRole('ADMIN') or hasRole('INTERVIEWER')")
    public String userAccess() {
        return "User Content.";
    }
    @GetMapping("/mod")
    @PreAuthorize("hasRole('BUSINESS')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }
    @GetMapping("/business")
    @PreAuthorize("hasRole('BUSINESS')")
    public String businessAccess() {
        return "Business Board.";
    }
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}