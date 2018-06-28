package com.helix.practice.demo2.Controller;

import com.helix.practice.demo2.Models.Users;
import com.helix.practice.demo2.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<Users> findAll() { return userService.findAll(); }

    @GetMapping(value = "/{id}")
    public Users findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping(value = "/signup")
    public Users signUp(@RequestBody Users user){ return userService.signUp(user); }

    @DeleteMapping(value = "/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

    @PutMapping(value="/{id}")
    public Users updateUserById(@PathVariable("id") Long id, @RequestBody Users users) {
        return userService.updateUserById(id, users);
    }
}
