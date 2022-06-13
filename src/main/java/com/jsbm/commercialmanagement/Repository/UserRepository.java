package com.jsbm.commercialmanagement.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jsbm.commercialmanagement.Model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
    Optional<User> findByNameOrEmail(String name, String email);
}
