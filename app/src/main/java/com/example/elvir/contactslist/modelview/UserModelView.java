package com.example.elvir.contactslist.modelview;

import android.widget.ImageView;

import com.example.elvir.contactslist.model.User;
import com.squareup.picasso.Picasso;


public class UserModelView {

    private User user;

    public UserModelView(User user){
        this.user=user;
    }


    public String getName(){
        return user.getName();
    }

    public String getGender(){
        return user.getGender();
    }

    public String getCity(){
        return user.getCity();
    }

    public String getPhone(){
        return user.getPhone();
    }

    public String getPhoto(){
        return user.getPhoto();
    }

    public String getEmail(){
        return user.getEmail();
    }


    public static void setPhoto(ImageView imageView,String url){
        Picasso.with(imageView
                .getContext())
                .load(url)
                .into(imageView);
    }

}
