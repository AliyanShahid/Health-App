package com.mhutshow.daktarlagbe.controller;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import com.mhutshow.daktarlagbe.R;

public class loading {
   private Activity activity;
    private AlertDialog alertDialog;

    loading(Activity myactivity){
        activity= myactivity;

    }
    void startloadingdialog(){
        AlertDialog.Builder builder= new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_dialog,null ));
        builder.setCancelable(false);
        alertDialog=builder.create();
        alertDialog.show();
    }
    void dismissdialog()
    {
        alertDialog.dismiss();
    }
}
