package com.MiniLibraryManagementSystem.MiniLibraryManagementSystem.service;

import com.MiniLibraryManagementSystem.MiniLibraryManagementSystem.data.model.User;
import com.MiniLibraryManagementSystem.MiniLibraryManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user){
        userRepository.save(user);
    }

    public User getUserById(@PathVariable int id){
        return userRepository.findById(id).orElseThrow();
    }

    public void deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll().stream().toList();
    }

}
