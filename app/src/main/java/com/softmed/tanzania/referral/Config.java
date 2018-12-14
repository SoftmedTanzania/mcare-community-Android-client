package com.softmed.tanzania.referral;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;

import java.io.IOException;

public class Config {
    public static final String ip = "http://192.168.43.58:5000/";
    public static final String login_url =ip + "user_login";
    public static final String chw_jurisdiction_villages =ip + "inner_join_villages_with_chw_jurisdiction_villages";
    public static final String chw_jurisdiction_facilities =ip + "get_specific_facilities";


    public static boolean isConnected() throws InterruptedException, IOException
    {
        String command = "ping -c 1 google.com";
        return (Runtime.getRuntime().exec (command).waitFor() == 0);
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void showMessage(Context context,String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(true);
        // builder.setView(R.layout.activity_main);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();}
}
