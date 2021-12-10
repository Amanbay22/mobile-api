package com.example.mobileapi;

import com.example.mobileapi.models.Image;
import com.example.mobileapi.models.User;
import com.example.mobileapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestParam(value = "email") String username, @RequestParam(value = "password") String password){
        User byUsername = userRepository.findByUsername(username);
        if(byUsername!=null) {
            if(password.equals(byUsername.getPassword())){
                return ResponseEntity.status(200).build();
            }
            else return ResponseEntity.status(201).build();
        }
        else return ResponseEntity.status(401).build();
    }

    @PostMapping("/reg")
    public ResponseEntity reg(@RequestParam(value = "email") String username, @RequestParam(value = "password") String password){
        if(userRepository.findByUsername(username)!=null){
            return ResponseEntity.status(201).build();
        } else {
            List<Image> images = new ArrayList<>();
            User user = new User(null, username, password, images);
            userRepository.save(user);
            return ResponseEntity.status(200).build();
        }


    }
}
