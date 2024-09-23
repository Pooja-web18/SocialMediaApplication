package com.NewSocialMediaApp.newsocialmedia_app.Controller;

import com.NewSocialMediaApp.newsocialmedia_app.Models.Like;
import com.NewSocialMediaApp.newsocialmedia_app.Repository.LikeRepository;
import com.NewSocialMediaApp.newsocialmedia_app.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikeController {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/post/{postId}")
    public List<Like> getLikesByPost(@PathVariable Long postId) {
        return likeRepository.findByPostId(postId);
    }

    @PostMapping
    public ResponseEntity<Like> createLike(@RequestBody Like like) {
        return postRepository.findById(like.getPost().getId())
                .map(post -> {
                    like.setPost(post);
                    return ResponseEntity.ok(likeRepository.save(like));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLike(@PathVariable Long id) {
        return likeRepository.findById(id)
                .map(like -> {
                    likeRepository.delete(like);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}