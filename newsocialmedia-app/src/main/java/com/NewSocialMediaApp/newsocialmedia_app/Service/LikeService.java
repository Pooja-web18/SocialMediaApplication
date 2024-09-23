package com.NewSocialMediaApp.newsocialmedia_app.Service;

import com.NewSocialMediaApp.newsocialmedia_app.Models.Like;

import java.util.List;
import java.util.Optional;

public interface LikeService {
    List<Like> findAll();
    Optional<Like> findById(Long id);
    Like save(Like like);
    void deleteById(Long id);
    List<Like> findByUserId(Long userId); // Method to find likes by user ID
    List<Like> findByPostId(Long postId); // Method to find likes by post ID

    List<Like> getLikesByPostId(Long postId);

    Optional<Like> createLike(Like like);

    boolean deleteLike(Long id);
}
