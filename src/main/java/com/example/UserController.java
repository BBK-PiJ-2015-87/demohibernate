package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/get-by-email")
    @ResponseBody
    public String getByEmail(String email) {
        User user;
        try {
            user = userDao.findByEmail(email);
        }
        catch (Exception ex) {
            return "User not found";
        }
        return "The user id is: " + user.getId() + " User username: " + user.getUsername();
    }
}
