package com.android.mdw.demo;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity implements OnClickListener {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    IntentFilter receiverFilter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
    ElReceptor receiver = new ElReceptor();
    registerReceiver(receiver, receiverFilter );

    Button btnSonido = (Button) findViewById(R.id.btnSonido);
    Button btnFin = (Button) findViewById(R.id.btnFin);
    Button btnCancion = (Button) findViewById(R.id.btnCancion);

    btnSonido.setOnClickListener(this);
    btnFin.setOnClickListener(this);
    btnCancion.setOnClickListener(this);

  }

  public void onClick(View src) {
    Intent i;
    switch (src.getId()) {
    case R.id.btnSonido:
      i = new Intent(this, ElReceptor.class);
      i.putExtra(getString(R.string.tipo), getString(R.string.sonido));
      sendBroadcast(i);
      break;
    case R.id.btnFin:
      i = new Intent(this, ElReceptor.class);
      i.putExtra(getString(R.string.tipo), getString(R.string.detener));
      sendBroadcast(i);
      break;
    case R.id.btnCancion:
      i = new Intent(this, ElReceptor.class);
      i.putExtra(getString(R.string.tipo), getString(R.string.cancion));
      sendBroadcast(i);
      break;
    }
  }
}