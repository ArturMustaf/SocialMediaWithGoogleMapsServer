package com.mustaf.socialmaps.repository;

import com.mustaf.socialmaps.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
