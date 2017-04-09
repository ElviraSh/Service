package com.example.elvir.contactslist.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.elvir.contactslist.model.retrofit.UserApi;
import com.example.elvir.contactslist.model.retrofit.pojo.Result;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;


public class UsersModel {

    public static final String USERS_DATA="SharedPreferences";

    private UserApi userApi;
    private Context context;

    public UsersModel(Context context){
        this.context=context;
        userApi = UserApi.getInstance();
    }

    public void loadUsers(){
        try {
            SharedPreferences sharedPreferences=context.getSharedPreferences(USERS_DATA,Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            List<Result> results= userApi.getUsersList(30).body().getResults();
            for(Result result:results){
                User user=new User(result);
                editor.putString(user.getId().toString(),user.toJson());
            }
            editor.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void clearCache(){
        SharedPreferences sharedPreferences=context.getSharedPreferences(USERS_DATA,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }
}
