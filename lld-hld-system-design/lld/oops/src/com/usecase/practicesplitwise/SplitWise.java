package com.usecase.practicesplitwise;

import java.util.HashMap;

public class SplitWise {

    private HashMap<String, User> users = new HashMap<>();

    private HashMap<String, Group> groups = new HashMap<>();

    // create user
    public User createUser(String id, String name) {
        User user = new User(id, name);
        users.put(id, user);
        return user;
    }

    // create group
    public Group createGroup(String id, String name) {
        Group group = new Group(id, name);
        groups.put(id,group);
        return group;
    }

    // overall balance of a user
    public double getOverallBalance(User user) {
        double balace = 0.0;
        for (Group group:groups.values()) {
            balace += group.getUserBalance(user);
        }
        return balace;
    }

}
