package com.helix.practice.demo2.Services;

import com.helix.practice.demo2.Models.Users;
import com.helix.practice.demo2.Repository.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserJPARepository userJPARepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public Users signUp(Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userJPARepository.save(user);
    }

    public List<Users> findAll() {
        return userJPARepository.findAll();
    }

    public Users findById(@PathVariable Long id){
        Optional<Users> user  = userJPARepository.findById(id);
        if(user.isPresent())
            return user.get();
        else
            throw new NoSuchElementException("User not found");
    }

    public void deleteById(Long id) {
        userJPARepository.deleteById(id);
    }

    public Users updateUserById(Long id, Users users) {

        Users u = userJPARepository.findById(id).orElseThrow(
                ()-> new EmptyResultDataAccessException(String.format("No Such User Present"),1));
        u.setUsername(users.getUsername());
        u.setTeamName(users.getTeamName());
        userJPARepository.save(u);
        return u;
    }

    public Users findByUserName(String username) {
        return userJPARepository.findByUsername(username);
    }
}
