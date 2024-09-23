package com.NewSocialMediaApp.newsocialmedia_app.Repository;

import com.NewSocialMediaApp.newsocialmedia_app.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    // You can add custom query methods here

    List<Post> findByUserId(Long userId);  // Example method to find posts by userId
}
