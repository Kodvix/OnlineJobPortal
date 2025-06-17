package com.kodvix.OnlineJobPortal.serviceimpl;

import com.kodvix.OnlineJobPortal.dto.AdminDto;
import com.kodvix.OnlineJobPortal.entity.Admin;
import com.kodvix.OnlineJobPortal.entity.User;
import com.kodvix.OnlineJobPortal.repository.AdminRepository;
import com.kodvix.OnlineJobPortal.repository.UserRepository;
import com.kodvix.OnlineJobPortal.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Admin save(AdminDto dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Admin admin = new Admin();

        admin.setUser(user);
        admin.setName(dto.getName());
        admin.setEmail(dto.getEmail());
        admin.setContactNumber(dto.getContactNumber());
        return adminRepository.save(admin);
    }

    @Override
    public Admin getById(Long id) {
        return adminRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin not found"));
    }

    @Override
    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin updateById(Long id, AdminDto dto) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found with ID: " + id));

        // Map updated user if userId is present
        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            admin.setUser(user);
        }
        //Admin admin = getById(id);
        admin.setName(dto.getName());
        admin.setEmail(dto.getEmail());
        admin.setContactNumber(dto.getContactNumber());
        return adminRepository.save(admin);
    }

    @Override
    public void deleteById(Long id) {
        adminRepository.deleteById(id);
    }
}
