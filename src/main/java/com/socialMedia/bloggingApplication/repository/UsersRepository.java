package com.socialMedia.bloggingApplication.repository;

import com.socialMedia.bloggingApplication.entities.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends MongoRepository<Users,String> {
}
