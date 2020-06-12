package com.rajdeep.blereciver;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferanceForBluetooth {

    public void save(Context mContext,String mValue){

        SharedPreferences pref = mContext.getSharedPreferences("bluetoothValue", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("bleValue", mValue); // Storing string


        editor.commit();

    }


    public String retrive(Context mContext){

        SharedPreferences pref = mContext.getSharedPreferences("bluetoothValue", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();

       String s= pref.getString("bleValue", null);


        editor.commit();

        return s;
    }
}
