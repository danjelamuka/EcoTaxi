package com.example.EcoTaxi.service;

import com.example.EcoTaxi.entity.Admin;
import com.example.EcoTaxi.repository.AdminRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {


    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminService(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Admin registerAdmin(Admin admin) {
        if (adminRepository.existsByEmail(admin.getEmail())) {

            throw new IllegalStateException("Email " + admin.getEmail() + " already in use.");
        }
        String encodedPassword = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(encodedPassword);

        return adminRepository.save(admin);
    }

    public Optional<Admin> login(String email, String rawPassword) {
        return adminRepository.findByEmail(email)
                .filter(admin -> passwordEncoder.matches(rawPassword, admin.getPassword()));
    }

    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }


    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public void deleteAdmin(Long id) {
        if (!adminRepository.existsById(id)) {
            throw new IllegalStateException("Admin with ID " + id + " not found.");
        }
        adminRepository.deleteById(id);
    }
}