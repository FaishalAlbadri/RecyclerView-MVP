package com.faishalbadri.rebuildmvpmovie.MVP.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.rebuildmvpmovie.MVP.data.Pojo;
import com.faishalbadri.rebuildmvpmovie.MVP.di.MainRepoInject;
import com.faishalbadri.rebuildmvpmovie.MVP.ui.MainActivityContract.View;
import com.faishalbadri.rebuildmvpmovie.R;
import com.faishalbadri.rebuildmvpmovie.Singleton.CobaSingleton;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View {

  @BindView(R.id.rvMVP)
  RecyclerView rvMVP;
  MainActivityPresenter mainActivityPresenter;
  Adapter adapter;
  ArrayList<Pojo.KategoriBean> resultItem;
  private static final String simpan = "simpan";


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    cobaSingleton();
    mainActivityPresenter = new MainActivityPresenter(
        MainRepoInject.provideToMainRepo(getApplicationContext()));
    mainActivityPresenter.onAttachView(this);

    resultItem = new ArrayList<>();


    adapter = new Adapter(MainActivity.this,resultItem);
    rvMVP.setLayoutManager(new LinearLayoutManager(this));
    rvMVP.setAdapter(adapter);

    if (savedInstanceState != null){
      ArrayList<Pojo.KategoriBean> data = savedInstanceState.getParcelableArrayList(simpan);
      this.resultItem.clear();
      this.resultItem.addAll(data);
      adapter.notifyDataSetChanged();
      Log.i("save","Ini Dari If");
    }else {
      mainActivityPresenter.getData();
      Log.i("Save","Ini dari else");
    }

  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putParcelableArrayList(simpan,resultItem);
  }

  private void cobaSingleton() {
    Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
      @Override
      public void run() {
        startActivity(new Intent(getApplicationContext(),CobaSingleton.class));
      }
    },10000);
  }

  @Override
  public void onSucces(List<Pojo.KategoriBean> data, String msg) {
    resultItem.clear();
    resultItem.addAll(data);
    adapter.notifyDataSetChanged();

    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onError(String msg) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
  }
}
