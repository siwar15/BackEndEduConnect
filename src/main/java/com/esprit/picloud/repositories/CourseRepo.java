package com.esprit.picloud.repositories;

import com.esprit.picloud.entities.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends MongoRepository<Course,String> {
}
