package com.mustaf.printingonmaps.repository;

import com.mustaf.printingonmaps.entity.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, String> {

}