package com.kodvix.OnlineJobPortal.controller;

import com.kodvix.OnlineJobPortal.dto.AdminDto;
import com.kodvix.OnlineJobPortal.entity.Admin;
import com.kodvix.OnlineJobPortal.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/save")
    public ResponseEntity<Admin> save(@Valid @RequestBody AdminDto dto) {
        return ResponseEntity.ok(adminService.save(dto));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Admin> get(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.getById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Admin>> getAll() {
        return ResponseEntity.ok(adminService.getAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Admin> update(@PathVariable Long id, @Valid @RequestBody AdminDto dto) {
        return ResponseEntity.ok(adminService.updateById(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        adminService.deleteById(id);
        return ResponseEntity.ok("Admin deleted successfully");
    }

}
