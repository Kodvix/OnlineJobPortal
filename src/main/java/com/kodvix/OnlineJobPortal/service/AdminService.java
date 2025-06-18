package com.kodvix.OnlineJobPortal.service;

import com.kodvix.OnlineJobPortal.dto.AdminDto;
import com.kodvix.OnlineJobPortal.entity.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    Admin save(AdminDto dto);
    Admin getById(Long id);
    List<Admin> getAll();
    Admin updateById(Long id, AdminDto dto);
    void deleteById(Long id);
}
