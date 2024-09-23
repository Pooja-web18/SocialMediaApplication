package com.NewSocialMediaApp.newsocialmedia_app.Repository;

import com.NewSocialMediaApp.newsocialmedia_app.Models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);
    List<Comment> findByUserId(Long userId);
    List<Comment> findByPostIdOrderByCreatedAtDesc(Long postId);
}