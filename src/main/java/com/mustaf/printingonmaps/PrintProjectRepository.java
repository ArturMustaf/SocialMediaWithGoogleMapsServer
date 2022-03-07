package com.mustaf.printingonmaps;

import com.mustaf.printingonmaps.entity.PrintProject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrintProjectRepository extends MongoRepository<PrintProject, String> { }
