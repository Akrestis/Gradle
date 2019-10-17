package com.company.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class Todos {
    private Integer userId;
    private Integer id;
    private String title;
    private Boolean completed;

    public Todos() {
    }

    public Todos(Integer userId, Integer id, String title, Boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public static String Print(List<Todos> list) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(list);
    }
}
