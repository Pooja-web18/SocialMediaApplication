package com.NewSocialMediaApp.newsocialmedia_app.Service;

import com.NewSocialMediaApp.newsocialmedia_app.Models.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Post save(Post post); // Save a post

    List<Post> findAll(); // Get all posts

    Optional<Post> findById(Long id); // Get post by ID

    void deleteById(Long id); // Delete post by ID

    List<Post> findByUserId(Long userId); // Find posts by user ID
}
