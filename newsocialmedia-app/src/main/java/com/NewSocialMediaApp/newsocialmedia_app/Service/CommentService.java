package com.NewSocialMediaApp.newsocialmedia_app.Service;

import com.NewSocialMediaApp.newsocialmedia_app.Models.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    Comment save(Comment comment);
    List<Comment> findByPostId(Long postId);
    Optional<Comment> findById(Long id);
    void deleteById(Long id);
}
