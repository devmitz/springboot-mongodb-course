package com.example.demo.services;

import com.example.demo.DTO.UserDTO;
import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.exception.ObjectNotFoundException;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> optionalPost = repository.findById(id);
        Post post = optionalPost.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
        return post;
    }

}
