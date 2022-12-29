package com.socialMedia.bloggingApplication.services;

import com.socialMedia.bloggingApplication.entities.Users;
import com.socialMedia.bloggingApplication.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private MongoTemplate mongoTemplate;
    public String addUser(@RequestBody Users user) {
        Users user1 = usersRepository.save(user);
        if(user1.equals(user)) {
            return "user added successfully";
        }
        else {
            return "There is some issue";
        }
    }

    public List<Users> findAllUsers() {
        return usersRepository.findAll();
    }

    public void deleteUserById(String id) {
        usersRepository.deleteById(id);
    }

    public Optional<Users> findUserById(String id) {
        return usersRepository.findById(id);

    }

    public String updateUser(Users user , String id) {
        Optional<Users> getUser = usersRepository.findById(id);
        if(getUser.isPresent()){
            usersRepository.save(user);
            return "User updated successsfullly";
        }
        else {
          return "user not find";
        }

    }
}
