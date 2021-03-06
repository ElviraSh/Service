package com.example.elvir.contactslist.view;


import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elvir.contactslist.R;
import com.example.elvir.contactslist.databinding.ItemUserBinding;
import com.example.elvir.contactslist.model.User;
import com.example.elvir.contactslist.modelview.UserItem;

import java.util.Collections;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<User> users;

    public UserAdapter(){
        users= Collections.emptyList();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemUserBinding itemUserBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_user, parent, false);
        return new UserViewHolder(itemUserBinding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((UserViewHolder) holder).bind(users.get(position));

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void setUsers(List<User> users){
        this.users=users;
        notifyDataSetChanged();
    }

    private class UserViewHolder extends RecyclerView.ViewHolder {

        private ItemUserBinding itemUserBinding;

        public UserViewHolder(ItemUserBinding itemUserBinding) {
            super(itemUserBinding.listItem);
            this.itemUserBinding = itemUserBinding;
        }

        public void bind(final User user) {
            if (itemUserBinding.getViewModel() == null) {
                itemUserBinding.setViewModel(new UserItem(user));
            } else {
                itemUserBinding.getViewModel().setUser(user);
            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context=itemView.getContext();
                    context.startActivity(new Intent(context, UserActivity.class).putExtra(UserActivity.KEY_USER,user));
                }
            });
        }
    }
}
