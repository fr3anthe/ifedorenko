package ru.job4j.servlets;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserStorage {
    private static final UserStorage INSTANCE = new UserStorage();
    private List<User> users = new CopyOnWriteArrayList<User>();

    private UserStorage() {
        this.users.add(new User("root", "root@root", "root"));
    }

    public void add(User user) {
        this.users.add(user);
    }

    public List<User> getUsers() {
        return this.users;
    }

    public static UserStorage getInstance() {
        return INSTANCE;
    }

    public boolean isCredential(String login, String password) {
        boolean exists = false;
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                exists = true;
                break;
            }
        }
        return exists;
    }
}
