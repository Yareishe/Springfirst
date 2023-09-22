package com.example.mes.notelist.serves;


import com.example.mes.notelist.entity.User;
import com.example.mes.notelist.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository loginRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User a = loginRepository.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(a.getUsername(), a.getPassword(), Collections.emptyList());
    }
}