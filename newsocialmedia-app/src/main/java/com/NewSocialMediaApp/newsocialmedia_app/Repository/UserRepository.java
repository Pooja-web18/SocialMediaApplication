package com.NewSocialMediaApp.newsocialmedia_app.Repository;

import com.NewSocialMediaApp.newsocialmedia_app.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
