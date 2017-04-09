package com.example.elvir.contactslist.modelview;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.example.elvir.contactslist.model.User;
import com.squareup.picasso.Picasso;


public class UserItem extends BaseObservable {

    private User user;

    public UserItem(User user){
        this.user=user;
    }

    public String getName(){
        return user.getName();
    }

    public String getPhoto(){
        return user.getPhoto();
    }

    public void setUser(User user) {
        this.user = user;
        notifyChange();
    }

    @BindingAdapter({"android:src"})
    public static void setPhoto(ImageView imageView,String urlImage){
        Picasso.with(imageView.getContext()).load(urlImage).into(imageView);
    }
}
