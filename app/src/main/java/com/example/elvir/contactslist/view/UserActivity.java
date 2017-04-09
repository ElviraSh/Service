package com.example.elvir.contactslist.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.elvir.contactslist.R;
import com.example.elvir.contactslist.databinding.ActivityUserBinding;
import com.example.elvir.contactslist.model.User;
import com.example.elvir.contactslist.modelview.UserModelView;


public class UserActivity extends AppCompatActivity {

    public static final String KEY_USER ="KEY_USER";

    private ActivityUserBinding activityUserBinding;
    private UserModelView userModelView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBinding();
    }

    private void initBinding(){
        userModelView=new UserModelView((User)getIntent().getSerializableExtra(KEY_USER));
        activityUserBinding= DataBindingUtil.setContentView(this, R.layout.activity_user);
        activityUserBinding.setViewModel(userModelView);
    }
}
