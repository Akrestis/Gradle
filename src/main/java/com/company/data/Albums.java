package com.company.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class Albums {
    private int userId;
    private int id;
    private String title;

    public Albums() {
    }

    public Albums(int userId, int id, String title) {
        this.userId = userId;
        this.id = id;
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public static String Print(List<Albums> list) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(list);
    }
}
