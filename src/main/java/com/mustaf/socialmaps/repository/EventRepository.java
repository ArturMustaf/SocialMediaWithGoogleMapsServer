package com.mustaf.socialmaps.repository;

import com.mustaf.socialmaps.entity.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, String> {
}