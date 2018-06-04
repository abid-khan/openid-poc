package com.example.openidpoc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.openidpoc.entity.User;
import com.example.openidpoc.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createOrUpdate(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User finByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByExternalId(String externalId) {
        return userRepository.findByExternalId(externalId);
    }
}
