package com.mustaf.printingonmaps.repository;

import com.mustaf.printingonmaps.entity.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, String> {
}