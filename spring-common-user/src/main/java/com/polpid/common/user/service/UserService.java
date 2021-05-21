package com.polpid.common.user.service;

import com.polpid.common.user.domain.Users;
import com.polpid.common.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> findAll(){
        return userRepository.findAll();
    }

    public Users findUserById(String id){
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
    }

    private boolean validateId(String id){
        return id==null?false:true;
    }
}
