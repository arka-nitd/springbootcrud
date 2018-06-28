package com.helix.practice.demo2.controller;

import com.helix.practice.demo2.models.AdminUser;
import com.helix.practice.demo2.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping()
    public List<AdminUser> findAll() { return adminService.findAll(); }

    @PostMapping()
    public AdminUser signUp(@RequestBody AdminUser user){ return adminService.signUp(user); }

    @GetMapping(value = "/{id}")
    public AdminUser findById(@PathVariable Long id){
        return adminService.findById(id);
    }

    @GetMapping(value = "/{name}")
    public AdminUser findById(@PathVariable String name){
        return adminService.findByUserName(name);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        adminService.deleteById(id);
    }

    @PutMapping(value="/{id}")
    public AdminUser updateUserById(@PathVariable("id") Long id, @RequestBody AdminUser adminUser) {
        return adminService.updateUserById(id, adminUser);
    }
}
