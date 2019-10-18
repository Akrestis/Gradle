package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FileStorage implements Storage {

    private UsersList usersList;

    FileStorage(String fileName) {
        try {
            String json = new Scanner(new File(fileName)).useDelimiter("\\Z").next();
            Gson gson = new Gson();
            usersList = gson.fromJson(json, UsersList.class);
            usersList.setId();
        } catch (FileNotFoundException e) {
            usersList = new UsersList();
            write();
        }
    }

    @Override
    public void removeAll() {
        usersList.removeAll();
        write();
    }

    @Override
    public void removeUser(int id) {
        usersList.removeUser(id);
        write();
    }

    @Override
    public void removeUserByName(String name) {
        usersList.removeUserByName(name);
        write();
    }

    @Override
    public void addUser(User user) {
        usersList.addUser(user);
        write();
    }

    @Override
    public void updateUser(User user) {
        usersList.updateUser(user);
        write();
    }

    @Override
    public User getUser(int id) {
        return usersList.getUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return usersList.getAllUsers();
    }

    private void write() {
        try {
            FileOutputStream os = new FileOutputStream(Main.FILE_NAME, false);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String temp = gson.toJson(usersList);
            bw.append(temp);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
