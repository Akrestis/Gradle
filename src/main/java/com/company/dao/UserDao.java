package com.company.dao;

import com.company.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private static UserDao instance;

    public static synchronized UserDao getInstance() {
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }

    private List<User> users = new ArrayList<>();

    public User getUser(int id){
        return users.get(id);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public void addUser(User user) {
        user.setId(users.size());
        users.add(user);
    }

    public void updateUser(int id, String name, int age) {
        users.get(id).setName(name);
        users.get(id).setAge(age);
    }

    public void deleteUser(int id){
        users.remove(id);
        while (id < users.size()){
            users.get(id).setId(id);
            id++;
        }
    }
}
