package com.NewSocialMediaApp.newsocialmedia_app.Controller;

import com.NewSocialMediaApp.newsocialmedia_app.Models.Post;
import com.NewSocialMediaApp.newsocialmedia_app.Models.User; // Import User
import com.NewSocialMediaApp.newsocialmedia_app.Service.PostService;
import com.NewSocialMediaApp.newsocialmedia_app.Service.UserService; // Import UserService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService; // Autowire UserService to fetch user details

    // Create a new post
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        // Log the incoming post to see its contents
        System.out.println("Received post: " + post);

        // Check if user ID is provided
        if (post.getUser() == null || post.getUser().getId() == null) {
            throw new RuntimeException("User ID must not be null");
        }

        // Attempt to find the user
        Long userId = post.getUser().getId();
        System.out.println("Attempting to find user with ID: " + userId);

        User user = userService.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Set the user for the post
        post.setUser(user);
        Post createdPost = postService.save(post);

        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }



    // Get all posts
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.findAll();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // Get a post by ID
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        return postService.findById(id)
                .map(post -> new ResponseEntity<>(post, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get posts by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> getPostsByUserId(@PathVariable Long userId) {
        List<Post> posts = postService.findByUserId(userId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // Delete a post by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
