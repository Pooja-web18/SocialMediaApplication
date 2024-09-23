package com.NewSocialMediaApp.newsocialmedia_app.Service.ServiceImpl;

import com.NewSocialMediaApp.newsocialmedia_app.Models.Like;
import com.NewSocialMediaApp.newsocialmedia_app.Repository.LikeRepository;
import com.NewSocialMediaApp.newsocialmedia_app.Repository.PostRepository;
import com.NewSocialMediaApp.newsocialmedia_app.Service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Like> findAll() {
        return List.of();
    }

    @Override
    public Optional<Like> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Like save(Like like) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Like> findByUserId(Long userId) {
        return List.of();
    }

    @Override
    public List<Like> findByPostId(Long postId) {
        return List.of();
    }

    @Override
    public List<Like> getLikesByPostId(Long postId) {
        return likeRepository.findByPostId(postId);
    }

    @Override
    public Optional<Like> createLike(Like like) {
        return postRepository.findById(like.getPost().getId())
                .map(post -> {
                    like.setPost(post);
                    return likeRepository.save(like);
                });
    }

    @Override
    public boolean deleteLike(Long id) {
        return likeRepository.findById(id)
                .map(like -> {
                    likeRepository.delete(like);
                    return true;
                })
                .orElse(false);
    }
}