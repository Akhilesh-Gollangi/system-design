package com.app.user_management;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    //GET -> fetching something
    //POST -> create resource
    //PUT -> update resource
    //DELETE -> Delete resource

    // url is HTTP method  + endpoint
    // we can have like this as well same endpoint,different HTTP methods
    // so both considered as different

    // GET + user
    // POST + user

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
    // we can use GETMapping as well it will also take request body
    // But conventions say to create resource use POST
    @PostMapping("user/create")
    public String createUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    // As we are updating specific id, we are using path variable
    @PutMapping("user/{id}")
    public String updateUser(@PathVariable  int id, @RequestBody User user) {
        return userService.updateUser(id,user);
    }

    // basically we do delete on unique things in most of the cases it is id
    // so on we are delete specific thing so we use path variable
    @DeleteMapping("user/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    // which is actually taking request tomcat server or our local host

    // localhost will take the request in a specific port like 8080
    // in this port tomcat will run which will take request and give to dispatcherServlet
    // will route to proper controller
    //it is on high level

    // instead of localhost you can use local machine ip as well


}
