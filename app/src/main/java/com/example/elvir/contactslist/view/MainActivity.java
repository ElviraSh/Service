package com.example.elvir.contactslist.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.elvir.contactslist.R;
import com.example.elvir.contactslist.databinding.ActivityMainBinding;
import com.example.elvir.contactslist.model.UsersModel;
import com.example.elvir.contactslist.model.UsersService;
import com.example.elvir.contactslist.modelview.UserList;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    private UserAdapter userAdapter;
    private ActivityMainBinding activityUserListBinding;
    private UserList userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSharedPreferences(UsersModel.USERS_DATA,MODE_PRIVATE).edit().clear().commit();
        initDataBinding();
        initUserList(activityUserListBinding.userList);
        startService(new Intent(this, UsersService.class).putExtra(UsersService.KEY_SERVICE_USERS,UsersService.LOAD));
    }

    private void initDataBinding(){
        activityUserListBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        userList =new UserList(this);
        userList.addObserver(this);
    }

    private void initUserList(RecyclerView recyclerView){
        userAdapter=new UserAdapter();
        recyclerView.setAdapter(userAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void update(Observable o, Object arg) {
        userAdapter.setUsers(userList.getUsers());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        startService(new Intent(this, UsersService.class).putExtra(UsersService.KEY_SERVICE_USERS,UsersService.CLEAR));
        userList.unregister();
    }
}

