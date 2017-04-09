package com.example.elvir.contactslist.model;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.example.elvir.contactslist.modelview.UserList;


public class UsersService extends IntentService {

    public static final String KEY_SERVICE_USERS="KEY_LOAD_USERS";

    public static final int LOAD=0;
    public static final int CLEAR=1;

    public UsersService() {
        super("UsersService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        UsersModel usersModel = new UsersModel(getApplicationContext());
        int action=intent.getIntExtra(KEY_SERVICE_USERS,-1);
        if(action==LOAD) {
            usersModel.loadUsers();
            Intent updateIntent = new Intent(UserList.BROADCAST_ACTION);
            sendBroadcast(updateIntent);
        }else if(action==CLEAR){
            usersModel.clearCache();
            stopSelf();
        }
    }
}
