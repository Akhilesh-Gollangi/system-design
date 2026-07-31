package splitwise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Splitwise {

    Map<String, User> users = new HashMap<>();

    Map<String, Group> groups = new HashMap<>();

    //create user
    public User createUser(String id, String name) {
        User user = new User(id, name);
        users.put(id, user);
        return user;
    }

    // create group
    public Group createGroup(String id, String name) {
        Group group = new Group(id,name);
        groups.put(id,group);
        return group;
    }

}
