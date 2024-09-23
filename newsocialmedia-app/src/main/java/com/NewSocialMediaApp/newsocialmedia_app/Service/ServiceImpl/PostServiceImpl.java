package com.NewSocialMediaApp.newsocialmedia_app.Service.ServiceImpl;

import com.NewSocialMediaApp.newsocialmedia_app.Models.Post;
import com.NewSocialMediaApp.newsocialmedia_app.Repository.PostRepository;
import com.NewSocialMediaApp.newsocialmedia_app.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<Post> findByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }
}
