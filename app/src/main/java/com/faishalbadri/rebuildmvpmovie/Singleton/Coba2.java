package com.faishalbadri.rebuildmvpmovie.Singleton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.faishalbadri.rebuildmvpmovie.R;

public class Coba2 extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_coba2);
    Toast.makeText(this, Singleton.getInstance().getString(), Toast.LENGTH_SHORT).show();
  }
}
