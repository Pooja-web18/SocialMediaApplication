package com.NewSocialMediaApp.newsocialmedia_app.Service;

import com.NewSocialMediaApp.newsocialmedia_app.Models.Follow;

import java.util.List;
import java.util.Optional;

public interface FollowService {
    Optional<Follow> createFollow(Follow follow); // Create a new follow relationship

    boolean deleteFollow(Long id); // Delete a follow relationship by ID

    List<Follow> getFollowersByUserId(Long userId); // Get followers of a user

    List<Follow> getFollowingByUserId(Long userId); // Get users that a user is following
}
