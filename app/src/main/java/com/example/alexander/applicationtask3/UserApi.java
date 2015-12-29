package com.example.alexander.applicationtask3;

import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;

/**
 * Created by Alexander on 12/23/2015.
 */
public interface UserApi {
    @GET("/users")
    retrofit.Call<Users> getUsers();

//    @GET("/api/v1/auth{id}")
//    retrofit.Call<User> getUser(@Path("id") String user_id);
//
//    @PUT("/api/v1/auth{id}")
//    retrofit.Call<User> updateUser(@Path("id") int user_id, @Body User user);
//
//    @POST("/api/v1/auth")
//    retrofit.Call<User> saveUser (@Body User user);
//
//    @DELETE("/api/v1/auth(id)")
//    retrofit.Call<User> deleteUser(@Path("id") String user_id);
}
