package com.example.finalProject.security.service;

import com.example.finalProject.user.User;
import com.example.finalProject.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UserRepo userRepo;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepo.findByEmail(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + username));

    return UserDetailsImpl.build(user);
  }

}
