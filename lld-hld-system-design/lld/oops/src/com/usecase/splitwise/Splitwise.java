package com.usecase.splitwise;

import java.util.HashMap;
import java.util.Map;

/**
 * Main manager class for the Splitwise system.
 * It creates and stores all users and groups so they can be used later in the flow.
 */
public class Splitwise {

    Map<String, User> users = new HashMap<>();

    Map<String, Group> groups = new HashMap<>();

    /**
     * Creates a user and saves it in the system.
     */
    public User createUser(String id, String name) {
        User user = new User(id, name);
        users.put(id, user);
        return user;
    }

    /**
     * Creates a group and saves it in the system.
     * The returned group is where members and shared expenses are managed.
     */
    public Group createGroup(String id, String name) {
        Group group = new Group(id,name);
        groups.put(id,group);
        return group;
    }

    public double getOverallBalanceofUser(String userId) {
        double totalAmount = 0;
        for (Group group:groups.values()) {
            totalAmount += group.getUserBalance(userId);
        }
        return totalAmount;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public Map<String, Group> getGroups() {
        return groups;
    }
}
