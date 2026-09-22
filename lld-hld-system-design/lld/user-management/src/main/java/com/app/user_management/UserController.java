package com.app.user_management;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    //GET -> fetching something
    //POST -> create resource
    //PUT -> update resource
    //DELETE -> Delete resource

    private UserService userService = new UserService();

    @GetMapping("users")
    public List<User> getUsers() {
       return userService.getAllUsers();
    }

    // we can take input in 3types
    // by path variable, request param, request body

    // path variable and request param are part of the url
    // we can use them any of these 2 but when to use what
    // Rest says
    // when to use path variable, if you want specific thing then use it
    // if you want filter on the data then use request param

    @GetMapping("users/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    // we will see Request param are in url but they are part of params
    // framework will search for age key in param
    @GetMapping("users/search")
    public List<User> getUsersByAge(@RequestParam int age) {
        return userService.getUserByAge(age);
    }

    //In postman we will give json, but function want user
    // Framework internally converts json to user
    @PostMapping("user/create")
    public String createUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
