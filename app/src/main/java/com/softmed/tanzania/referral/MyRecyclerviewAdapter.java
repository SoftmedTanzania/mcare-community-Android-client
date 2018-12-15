package com.softmed.tanzania.referral;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyRecyclerviewAdapter  extends RecyclerView.Adapter<MyRecyclerviewHolder> {
    Context context;

    public MyRecyclerviewAdapter(Context context) {

     this.context=context;


    }


    @Override
    public MyRecyclerviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

      View layoutView = LayoutInflater.from(context).inflate(R.layout.location_pop,null);
        MyRecyclerviewHolder rcv = new MyRecyclerviewHolder(layoutView);

        return rcv;
    }


    @Override
    public void onBindViewHolder(MyRecyclerviewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {

       //return this.FullNames.size();
        return 0;
    }



    @Override
    public long getItemId(int position) {
        return 0;
    }

}
