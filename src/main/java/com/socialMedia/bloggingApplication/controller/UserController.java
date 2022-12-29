package com.socialMedia.bloggingApplication.controller;

import com.socialMedia.bloggingApplication.entities.Users;
import com.socialMedia.bloggingApplication.repository.UsersRepository;
import com.socialMedia.bloggingApplication.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/addUser")
    public String addUser(@RequestBody Users user){

        String result = userServices.addUser(user);
        return result;
    }
    @GetMapping("/findUserById/{id}")
    public Optional<Users> getUser(@PathVariable String id) {

        return userServices.findUserById(id);
    }
    @GetMapping("/findAllUsers")
    public List<Users> getUsers() {

        return userServices.findAllUsers();
    }
    @RequestMapping("/updateUser/{id}")
    public String updateUser(@RequestBody Users user,  @PathVariable String id){
        String result =userServices.updateUser(user,id);
        return result;
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable String id){
        userServices.deleteUserById(id);
        return "Deleted Successfully";
    }

}
