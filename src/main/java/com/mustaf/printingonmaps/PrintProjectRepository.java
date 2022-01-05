package com.mustaf.printingonmaps;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrintProjectRepository extends MongoRepository<PrintProject, Long> { }
