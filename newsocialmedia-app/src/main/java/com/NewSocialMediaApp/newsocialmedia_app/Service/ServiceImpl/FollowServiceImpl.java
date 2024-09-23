package com.NewSocialMediaApp.newsocialmedia_app.Service.ServiceImpl;

import com.NewSocialMediaApp.newsocialmedia_app.Models.Follow;
import com.NewSocialMediaApp.newsocialmedia_app.Repository.FollowRepository;
import com.NewSocialMediaApp.newsocialmedia_app.Service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowRepository followRepository;

    @Override
    public Optional<Follow> createFollow(Follow follow) {
        // Save the follow relationship
        return Optional.of(followRepository.save(follow));
    }

    @Override
    public List<Follow> getFollowersByUserId(Long userId) {
        // Get all followers for the specified user
        return followRepository.findByFollowedUser_Id(userId);
    }

    @Override
    public List<Follow> getFollowingByUserId(Long userId) {
        // Get all users that the specified user is following
        return followRepository.findByFollower_Id(userId);
    }

    @Override
    public boolean deleteFollow(Long id) {
        // Check if the follow relationship exists and delete it
        if (followRepository.existsById(id)) {
            followRepository.deleteById(id);
            return true;
        }
        return false; // Return false if the follow relationship does not exist
    }
}
