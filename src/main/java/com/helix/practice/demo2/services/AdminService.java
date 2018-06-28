package com.helix.practice.demo2.services;

import com.helix.practice.demo2.models.AdminUser;
import com.helix.practice.demo2.repository.AdminJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminJpaRepository adminJpaRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public AdminUser signUp(AdminUser adminUser) {
        adminUser.setPassword(bCryptPasswordEncoder.encode(adminUser.getPassword()));
        return adminJpaRepository.save(adminUser);
    }

    public List<AdminUser> findAll() {
        return adminJpaRepository.findAll();
    }

    public AdminUser findById(@PathVariable Long id){
        Optional<AdminUser> admin  = adminJpaRepository.findById(id);
        if(admin.isPresent())
            return admin.get();
        else
            throw new NoSuchElementException("AdminUser not found");
    }

    public void deleteById(Long id) {
        adminJpaRepository.deleteById(id);
    }

    public AdminUser updateUserById(Long id, AdminUser adminUser) {

        AdminUser u = adminJpaRepository.findById(id).orElseThrow(
                ()-> new EmptyResultDataAccessException(String.format("No Such AdminUser Present"),1));
        u.setUsername(adminUser.getUsername());
        u.setPassword(bCryptPasswordEncoder.encode(adminUser.getPassword()));
        adminJpaRepository.save(u);
        return u;
    }

    public AdminUser findByUserName(String name) {
        return adminJpaRepository.findByUsername(name);
    }
}
