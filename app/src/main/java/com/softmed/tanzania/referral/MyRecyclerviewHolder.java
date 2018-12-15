package com.softmed.tanzania.referral;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MyRecyclerviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public MyRecyclerviewHolder(View itemView) {
        super(itemView);


        itemView.setOnClickListener(this);


    }



    @Override
    public void onClick(View view) {

    }
}
