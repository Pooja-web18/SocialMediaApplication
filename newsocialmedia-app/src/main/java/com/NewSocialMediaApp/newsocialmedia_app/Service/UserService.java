package com.NewSocialMediaApp.newsocialmedia_app.Service;

import com.NewSocialMediaApp.newsocialmedia_app.Models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    Optional<User> getUserByUsername(String username);
    User createUser(User user);
    Optional<User> updateUser(Long id, User userDetails);
    boolean deleteUser(Long id);
    Optional<User> findById(Long id);
}
