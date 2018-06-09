package com.example.acer.simplehabit.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.example.acer.simplehabit.R;
import com.example.acer.simplehabit.data.vo.SessionsVO;
import com.example.acer.simplehabit.viewholders.ItemSessionsViewHolder;

/**
 * Created by Acer on 6/3/2018.
 */

public class SessionsAdapter extends BaseRecyclerAdapter <ItemSessionsViewHolder,SessionsVO>{


    public SessionsAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ItemSessionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_sessions,parent,false);
        return new ItemSessionsViewHolder(view);
    }




}
