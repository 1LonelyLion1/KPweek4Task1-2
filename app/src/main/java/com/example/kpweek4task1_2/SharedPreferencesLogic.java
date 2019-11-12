package com.example.kpweek4task1_2;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesLogic {

    private SharedPreferences mSharedPreferences;
    public static final String APP_PREFERENCES = "SEARCH_SETTINGS";
    final String KEY_RADIOBUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX";

    public SharedPreferencesLogic(Context context) {
        mSharedPreferences = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    public void SaveSearchPrefernces( int value){
        mSharedPreferences.edit().putInt(KEY_RADIOBUTTON_INDEX,value).apply();
    }

    public int LoadSearchPrefernces(){
        return mSharedPreferences.getInt(KEY_RADIOBUTTON_INDEX,-1);
    }


}
