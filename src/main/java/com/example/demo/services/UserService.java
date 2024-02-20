package com.example.demo.services;

import com.example.demo.domain.User;
import com.example.demo.exception.ObjectNotFoundException;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> optionalUser = repository.findById(id);
        User user = optionalUser.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
        return user;
    }
}
