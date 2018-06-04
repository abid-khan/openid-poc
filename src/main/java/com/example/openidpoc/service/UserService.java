package com.example.openidpoc.service;


import com.example.openidpoc.entity.User;

public interface UserService {
    public User createOrUpdate(User user);
    public User finByEmail(String email);
    public User findByExternalId(String externalId);
}
