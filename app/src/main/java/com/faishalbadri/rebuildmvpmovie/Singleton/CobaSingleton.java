package com.faishalbadri.rebuildmvpmovie.Singleton;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.widget.Toast;
import com.faishalbadri.rebuildmvpmovie.R;

public class CobaSingleton extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_coba_singleton);

    Toast.makeText(getApplicationContext(), Singleton.getInstance().getString(), Toast.LENGTH_SHORT).show();

    Singleton.getInstance().setString("Singleton");
    Handler hand =  new Handler();
    hand.postDelayed(new Runnable() {
      @Override
      public void run() {
        startActivity(new Intent(getApplicationContext(), Coba2.class));
      }
    },2000);
  }
}
