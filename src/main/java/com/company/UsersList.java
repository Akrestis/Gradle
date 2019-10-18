package com.company;

import java.util.ArrayList;
import java.util.List;

class UsersList {

    private static int id;
    private List<User> usersList;

    UsersList() {
        usersList = new ArrayList<>();
    }

    void setId() {
        id = usersList.size();
    }

    static int getId() {
        return id;
    }

    void removeAll() {
        usersList.clear();
        id = usersList.size();
    }

    void removeUser(int id) {
        usersList.remove(id);
        while (id != usersList.size()) {
            usersList.get(id).setId(id);
            id++;
        }
        UsersList.id = usersList.size();
    }

    void removeUserByName(String name) {
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).getName().equals(name)) {
                usersList.remove(i);
                while (i != usersList.size()) {
                    usersList.get(i).setId(i);
                    i++;
                }
                break;
            }
        }
        id = usersList.size();
    }

    void addUser(User user) {
        usersList.add(user);
        id = usersList.size();
    }

    void updateUser(User user) {
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).getName().equals(user.getName())) {
                usersList.get(i).setAge(user.getAge());
            }
        }
    }

    User getUser(int id) {
        return usersList.get(id);
    }

    List<User> getAllUsers() {
        return usersList;
    }

    @Override
    public String toString() {
        return "UsersList{" +
                "usersList=" + usersList +
                '}';
    }
}
