package com.example.elvir.contactslist.model.retrofit;

import com.example.elvir.contactslist.model.retrofit.pojo.Users;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class UserApi {

    private final String API_URL = "https://randomuser.me/";
    private ApiCall apiCall;
    private static UserApi userApi;

    private UserApi() {
        init();
    }

    private void init() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiCall = retrofit.create(ApiCall.class);

    }

    public static UserApi getInstance() {
        if (userApi == null) {
            userApi = new UserApi();
        }
        return userApi;
    }

    public Response<Users> getUsersList(int countUser) throws IOException {
        Call<Users> userCall = apiCall.getUsers(countUser);
        Response<Users> userResponse = userCall.execute();
        return userResponse;
    }
}
