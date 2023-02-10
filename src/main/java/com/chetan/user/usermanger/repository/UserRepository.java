package com.chetan.user.usermanger.repository;

import com.chetan.user.usermanger.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
