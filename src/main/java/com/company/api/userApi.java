package com.company.api;

import com.company.dao.UserDao;
import com.company.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
public class userApi {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") int id) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String result = gson.toJson(UserDao.getInstance().getUser(id));
            return Response.status(Response.Status.OK)
                    .entity(result)
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("There is no user with such id")
                    .build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        List<User> users = UserDao.getInstance().getAllUsers();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String result = gson.toJson(users);
        return Response.status(Response.Status.OK)
                .entity(result)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createNewUser(@FormParam("name") String name, @FormParam("age") int age) {
        User user = new User(name, age);
        UserDao.getInstance().addUser(user);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String result = gson.toJson(user);
        return Response.status(Response.Status.OK)
                .entity(result)
                .build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response updateUser(@FormParam("id") int id, @FormParam("name") String name, @FormParam("age") int age) {
        try {
            UserDao.getInstance().updateUser(id, name, age);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String result = gson.toJson(UserDao.getInstance().getUser(id));
            return Response.status(Response.Status.OK)
                    .entity(result)
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("There is no user with such id")
                    .build();
        }
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response deleteUser(@FormParam("id") int id){
        try {
            UserDao.getInstance().deleteUser(id);
            return Response.status(Response.Status.OK)
                    .entity("User deleted")
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("There is no user with such id")
                    .build();
        }
    }
}
