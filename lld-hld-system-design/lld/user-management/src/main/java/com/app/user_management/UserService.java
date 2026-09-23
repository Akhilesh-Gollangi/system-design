package com.app.user_management;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User(1, "Akhilesh", 24));
        users.add(new User(2, "Baji", 26));
        users.add(new User(3, "Eshu", 23));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public List<User> getUserByAge(int age) {
        List<User> userList = new ArrayList<>();
        for (User user : users) {
            if (user.getAge() == age) {
                userList.add(user);
            }
        }
        return userList;
    }

    public String addUser(User user) {
        users.add(user);
        return "User created Successfully";
    }

    public String deleteUser(int id) {
        User user = getUserById(id);
        if (user != null) {
            users.remove(user);
            return "User deleted successfully";
        }
        throw new RuntimeException("User with id "+ id + "not found");
    }

    public String updateUser(int id, User updatedUser) {
        User user = getUserById(id);
        if (user != null) {
            deleteUser(id);
            addUser(updatedUser);
        }
        return "User updated Successfully";
    }


}
