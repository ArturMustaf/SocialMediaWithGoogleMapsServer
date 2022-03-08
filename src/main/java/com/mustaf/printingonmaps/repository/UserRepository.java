package com.mustaf.printingonmaps.repository;

import com.mustaf.printingonmaps.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
