package com.android.mdw.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;



public class ElReceptor extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        intent.setClass(context,ElServicio.class);
        String extra1 = intent.getExtras().getString(context.getString(R.string.tipo));
        if (extra1 != null){
            if (extra1.equals(context.getString(R.string.cancion)) || extra1.equals(context.getString(R.string.sonido))){
                Toast.makeText(context, context.getString(R.string.toastB) + " " + extra1, Toast.LENGTH_LONG).show();
                context.startService(intent);
            } else {
                Toast.makeText(context, context.getString(R.string.toastB) + " " + extra1, Toast.LENGTH_LONG).show();
                context.stopService(intent);
            }
        } else {
            if (intent.getIntExtra("state", 0) == 1){
                Toast.makeText(context, "Headset plugged", Toast.LENGTH_LONG).show();
                intent.putExtra(context.getString(R.string.tipo), context.getString(R.string.cancion));
                context.startService(intent);
            } else {
                Toast.makeText(context, "Headset unplugged ", Toast.LENGTH_LONG).show();
                context.stopService(intent);
            }
        }

    }
}
