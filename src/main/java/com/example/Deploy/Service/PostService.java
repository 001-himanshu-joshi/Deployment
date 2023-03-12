package com.example.Deploy.Service;

import com.example.Deploy.Model.Post;
import com.example.Deploy.dao.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
    public int addPost(Post post) {
        return postRepository.save(post).getId();
    }

    public List<Post> getPost() {
        return postRepository.findAll();
    }

    public Post getPostById(int postId) {
        return postRepository.findById(postId).get();
    }

    public void deleteById(int postId) {
        postRepository.deleteById(postId);
    }
}
