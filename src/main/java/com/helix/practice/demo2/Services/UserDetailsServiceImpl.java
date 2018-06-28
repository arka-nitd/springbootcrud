package com.helix.practice.demo2.Services;

import com.helix.practice.demo2.Models.Users;
import com.helix.practice.demo2.Repository.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserJPARepository userJPARepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users user = userJPARepository.findByUsername(s);
        if(null == user)
            throw new UsernameNotFoundException(s);
        return new User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }
}
