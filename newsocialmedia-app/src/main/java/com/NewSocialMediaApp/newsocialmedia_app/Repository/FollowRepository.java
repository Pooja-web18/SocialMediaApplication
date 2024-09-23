package com.NewSocialMediaApp.newsocialmedia_app.Repository;

import com.NewSocialMediaApp.newsocialmedia_app.Models.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {

    // Find all followers of a specific user
    List<Follow> findByFollowedUser_Id(Long followedUserId);

    // Find all users that a specific user is following
    List<Follow> findByFollower_Id(Long followerId);
}
