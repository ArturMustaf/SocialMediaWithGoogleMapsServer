package com.mustaf.printingonmaps.repository;

import com.mustaf.printingonmaps.entity.PrintProject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrintProjectRepository extends MongoRepository<PrintProject, String> { }
