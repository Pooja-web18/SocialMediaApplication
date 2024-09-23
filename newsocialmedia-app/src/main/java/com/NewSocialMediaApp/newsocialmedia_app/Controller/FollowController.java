package com.NewSocialMediaApp.newsocialmedia_app.Controller;

import com.NewSocialMediaApp.newsocialmedia_app.Models.Follow;
import com.NewSocialMediaApp.newsocialmedia_app.Service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/follows")
public class FollowController {

    @Autowired
    private FollowService followService;

    @GetMapping("/{userId}/followers")
    public ResponseEntity<List<Follow>> getFollowersByUserId(@PathVariable Long userId) {
        List<Follow> followers = followService.getFollowersByUserId(userId);
        return ResponseEntity.ok(followers);
    }

    @GetMapping("/{userId}/following")
    public ResponseEntity<List<Follow>> getFollowingByUserId(@PathVariable Long userId) {
        List<Follow> following = followService.getFollowingByUserId(userId);
        return ResponseEntity.ok(following);
    }

    @PostMapping
    public ResponseEntity<Follow> createFollow(@RequestBody Follow follow) {
        return followService.createFollow(follow)
                .map(savedFollow -> ResponseEntity.ok(savedFollow))
                .orElse(ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFollow(@PathVariable Long id) {
        if (followService.deleteFollow(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
