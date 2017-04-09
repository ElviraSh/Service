package com.example.elvir.contactslist.model.retrofit;

import com.example.elvir.contactslist.model.retrofit.pojo.Users;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;



public interface ApiCall {

    @GET("api")
    Call<Users> getUsers(@Query("results") int countUser);

}
