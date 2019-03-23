package com.android.mdw.demo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class ElServicio extends Service {

	private MediaPlayer playerSonido;
	private MediaPlayer playerCancion;


	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		Toast.makeText(this, R.string.creaserv, Toast.LENGTH_LONG).show();		
		playerSonido = MediaPlayer.create(this, R.raw.train);
		playerSonido.setLooping(true);
		playerCancion = MediaPlayer.create(this, R.raw.bob_marley_cybl);
		playerCancion.setLooping(true);
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, R.string.finaserv, Toast.LENGTH_LONG).show();
		playerCancion.stop();
		playerSonido.stop();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startid) {
		Toast.makeText(this, R.string.iniserv, Toast.LENGTH_LONG).show();
		String extra = intent.getExtras().getString(getString(R.string.tipo));
		if (extra.equals(getString(R.string.sonido))) {
			playerSonido.start();
		}else {
			playerCancion.start();
		}
		return startid;
	}	

}
