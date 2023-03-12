package com.example.Deploy.Controller;

import com.example.Deploy.Model.Post;
import com.example.Deploy.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/savePost")
    public ResponseEntity savePost(Post post){
        int postId = postService.addPost(post);
        return new ResponseEntity<>("Post is added to database with Post ID "+postId, HttpStatus.CREATED);
    }

    @GetMapping("/getAllPost")
    public List<Post> getAllPost(){
        return postService.getPost();
    }
    @GetMapping("/getPostById/{postId}")
    public Post getPost(@PathVariable int postId){
        return postService.getPostById(postId);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity deletePost(@PathVariable int postId){
        postService.deleteById(postId);
        return new ResponseEntity<>("Delete Post with Post Id "+postId, HttpStatus.OK);
    }

}
