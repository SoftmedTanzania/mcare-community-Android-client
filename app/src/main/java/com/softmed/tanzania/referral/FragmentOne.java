package com.softmed.tanzania.referral;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment {
    String UserId;
    ArrayList<MyBasket> clients_list;

    public FragmentOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        UserId=Config.getCurrentSessionId(getActivity());
        clients_list = new ArrayList<>();
        getSpecificChwClients();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
    }


    private void getSpecificChwClients(){


        StringRequest stringRequest = new StringRequest(Request.Method.POST,Config.get_my_clients, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {



                //Displaying our grid
                try {
                    JSONObject object = new JSONObject(s);
                    JSONArray jsonarray= object.getJSONArray("result");

                    for(int i = 0; i<jsonarray.length(); i++){

                        //Creating a json object of the current index
                        JSONObject obj = null;
                        try {

                            obj = jsonarray.getJSONObject(i);


                            String ClientId=obj.getString("ClientId");
                            String UserId=obj.getString("UserId");
                            String FirstName=obj.getString("FirstName");
                            String MiddleName=obj.getString("MiddleName");
                            String SurName=obj.getString("SurName");
                            String PhoneNumber=obj.getString("PhoneNumber");
                            String Email=obj.getString("Email");
                            String PhysicalAddress=obj.getString("PhysicalAddress");
                            String DOB=obj.getString("DOB");
                            String Gender=obj.getString("Gender");
                            String VillageId=obj.getString("VillageId");
                            String VillageName=obj.getString("VillageName");
                            String WardId=obj.getString("WardId");
                            String WardName=obj.getString("WardName");
                            String VillageRefNo=obj.getString("VillageRefNo");
                            String WardRefNo=obj.getString("WardRefNo");
                            String IsAChildOf=obj.getString("IsAChildOf");
                            String RegistrationDate=obj.getString("RegistrationDate");

                            /*String VillageId=obj.getString("VillageId");
                            String VillageName=obj.getString("VillageName");
                            String VillageRefNo=obj.getString("VillageRefNo");*/


                           // clients_list.add(new ClientModel());


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("ggg", volleyError.toString());
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<String, String>();

                params.put("column_name","UserId");
                params.put("search_value",UserId);



                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        //Adding our request to the queue
        requestQueue.add(stringRequest);
    }

}
