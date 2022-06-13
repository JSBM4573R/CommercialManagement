package com.jsbm.commercialmanagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsbm.commercialmanagement.Model.User;
import com.jsbm.commercialmanagement.Repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;

    public List<User> getAll(){
        return (List<User>) userRepo.findAll();
    }

    public Optional<User> getUser(Integer userId){
        return userRepo.findById(userId);
    }

    public User save(User user){
        return userRepo.save(user);
    }

    public void update(User user){
        userRepo.save(user);
    }

    public void delete(User user){
        userRepo.delete(user);
    }

    public boolean emailExists(String email){
        Optional<User> user = userRepo.findByEmail(email);
        return user.isPresent();
    }

    public Optional<User> authenticateUser(String email, String password){
        return userRepo.findByEmailAndPassword(email, password);
    }

    public Optional<User> getUserByNameOrEmail(String name, String email){
        return userRepo.findByNameOrEmail(name, email);
    }
}
