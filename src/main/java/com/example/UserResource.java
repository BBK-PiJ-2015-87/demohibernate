package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/user")
    User getByEmailJson(@RequestParam(value = "email", required = false, defaultValue = "vlado@email.com") String email){
        User user = new User();
        try {
            user = userDao.findByEmail(email);

        } catch (Exception e){
            //we can log here
        }

        return user;
    }

    @RequestMapping("/allusers")
    List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        try {
            Iterable<User> iter = userDao.findAll();
            for (User u : iter) {
                users.add(u);
            }

        } catch (Exception e){
            //we can log here
        }

        return users;
    }

    @RequestMapping("/addemptyuser")
    User addEmptyuser(){
        User user = new User();
        user.setEmail("user@email.com");
        user.setUsername("name");
        user.setPassword("password");
        try {
            userDao.save(user);

        } catch (Exception e){
            //we can log here
        }

        return user;
    }
}
