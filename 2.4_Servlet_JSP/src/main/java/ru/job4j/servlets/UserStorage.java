package ru.job4j.servlets;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserStorage {
    private static final UserStorage INSTANCE = new UserStorage();
    private List<User> users = new CopyOnWriteArrayList<User>();

    private UserStorage() {
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
}
