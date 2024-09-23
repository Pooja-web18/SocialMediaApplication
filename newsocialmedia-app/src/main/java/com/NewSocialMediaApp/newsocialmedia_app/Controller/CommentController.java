package com.NewSocialMediaApp.newsocialmedia_app.Controller;

import com.NewSocialMediaApp.newsocialmedia_app.Models.Comment;
import com.NewSocialMediaApp.newsocialmedia_app.Repository.PostRepository;
import com.NewSocialMediaApp.newsocialmedia_app.Service.CommentService;
import com.NewSocialMediaApp.newsocialmedia_app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService; // Assuming you have UserService to find the user

    @GetMapping("/post/{postId}")
    public List<Comment> getCommentsByPost(@PathVariable Long postId) {
        return commentService.findByPostId(postId);
    }

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        // Ensure you set the user from your context or request
        if (comment.getUser() == null || comment.getUser().getId() == null) {
            throw new RuntimeException("User ID must not be null");
        }

        // Set the user for the comment
        comment.setUser(userService.findById(comment.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found")));

        return postRepository.findById(comment.getPost().getId())
                .map(post -> {
                    comment.setPost(post);
                    return ResponseEntity.ok(commentService.save(comment));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody Comment commentDetails) {
        return commentService.findById(id)
                .map(comment -> {
                    comment.setContent(commentDetails.getContent());
                    return ResponseEntity.ok(commentService.save(comment));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Long id) {
        return commentService.findById(id)
                .map(comment -> {
                    commentService.deleteById(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
