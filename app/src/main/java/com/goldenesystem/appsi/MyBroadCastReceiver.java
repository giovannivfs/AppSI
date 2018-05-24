package com.goldenesystem.appsi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 *
 */
public class MyBroadCastReceiver extends BroadcastReceiver {
    /**
     * Classe utilizada para verificar se o celular entrou em Modo Avião.
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("android.intent.action.AIRPLANE_MODE")){
            Bundle extras = intent.getExtras();

            boolean state = extras.getBoolean("state");

            Log.d("AppSi","Modo Avião " + state);
        }
    }
}
