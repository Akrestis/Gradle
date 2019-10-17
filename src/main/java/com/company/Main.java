package com.company;

import com.company.data.Users;
import com.company.data.Todos;
import com.company.data.Albums;
import com.company.data.Comments;
import com.company.data.Photos;
import com.company.data.Posts;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        //1) Написать класс MyApiService с использованием паттерна синглтон для доступа к API

        MyApiService service = MyApiService.getInstance();

        Posts posts = new Posts();
        List<Posts> listPosts = service.getPosts();
        System.out.println(posts.Print(listPosts));

        Comments comments = new Comments();
        List<Comments> listComments = service.getComments();
        System.out.println(comments.Print(listComments));

        Albums albums = new Albums();
        List<Albums> listAlbums = service.getAlbums();
        System.out.println(albums.Print(listAlbums));

        Photos photos = new Photos();
        List<Photos> listPhotos = service.getPhotos();
        System.out.println(photos.Print(listPhotos));

        Todos todos = new Todos();
        List<Todos> listTodos = service.getTodos();
        System.out.println(todos.Print(listTodos));

        Users users = new Users();
        List<Users> listUsers = service.getUsers();
        System.out.println(users.Print(listUsers));
    }
}
