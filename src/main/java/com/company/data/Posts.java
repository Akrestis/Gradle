package com.company.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class Posts {
    private int userId;
    private int id;
    private String title;
    private String body;

    public Posts() {
    }

    public Posts(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
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

    public String getBody() {
        return body;
    }

    public static String Print(List<Posts> list) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(list);
    }
}
