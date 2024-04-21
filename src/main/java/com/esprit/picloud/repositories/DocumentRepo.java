package com.esprit.picloud.repositories;

import com.esprit.picloud.entities.Documentt;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepo extends MongoRepository<Documentt,String> {
}
