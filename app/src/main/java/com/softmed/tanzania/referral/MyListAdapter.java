package com.softmed.tanzania.referral;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class MyListAdapter extends ArrayAdapter<MyBasket> {
    LayoutInflater inflater;
    Button btContinueBook,btCancelBook;
    android.app.AlertDialog alertDialog;
    List<MyBasket> mybasketList;
    Context context;
    int resource;


    public MyListAdapter(Context context, int resource, List<MyBasket> mybasketList) {
        super(context, resource, mybasketList);
        this.context = context;
        this.resource = resource;
        this.mybasketList = mybasketList;


        inflater = (LayoutInflater) this.context.getSystemService(this.context.LAYOUT_INFLATER_SERVICE);
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(resource, null, false);
        TextView textViewName = (TextView) view.findViewById(R.id.textViewName);
        MyBasket basket_object = mybasketList.get(position);

        textViewName.setText(basket_object.getByName());




        textViewName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });




        return view;
    }


}