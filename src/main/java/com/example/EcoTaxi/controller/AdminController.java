package com.example.EcoTaxi.controller;

import com.example.EcoTaxi.entity.Admin;
import com.example.EcoTaxi.model.AdminResponse;
import com.example.EcoTaxi.model.LoginRequest;
import com.example.EcoTaxi.model.LoginResponse;

import com.example.EcoTaxi.security.JwtUtil;
import com.example.EcoTaxi.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admins")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    private final AdminService adminService;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Admin admin) {
        try {
            Admin savedAdmin = adminService.registerAdmin(admin);
            AdminResponse response = new AdminResponse(
                    savedAdmin.getId(),
                    savedAdmin.getName(),
                    savedAdmin.getLastName(),
                    savedAdmin.getEmail()
            );
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Optional<Admin> optionalAdmin = adminService.login(request.getEmail(), request.getPassword());

        if (optionalAdmin.isPresent()) {
            Admin admin = optionalAdmin.get();
            String token = jwtUtil.generateToken(admin.getEmail());

            AdminResponse adminResponse = new AdminResponse(
                    admin.getId(),
                    admin.getName(),
                    admin.getLastName(),
                    admin.getEmail()
            );
            LoginResponse loginResponse = new LoginResponse(token, adminResponse);

            return ResponseEntity.ok(loginResponse);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }

    @GetMapping
    public ResponseEntity<List<AdminResponse>> getAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();

        List<AdminResponse> adminResponses = admins.stream()
                .map(admin -> new AdminResponse(
                        admin.getId(),
                        admin.getName(),
                        admin.getLastName(),
                        admin.getEmail()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(adminResponses);
    }
}