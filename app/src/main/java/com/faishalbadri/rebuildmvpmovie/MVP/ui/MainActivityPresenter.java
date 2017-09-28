package com.faishalbadri.rebuildmvpmovie.MVP.ui;

import com.faishalbadri.rebuildmvpmovie.MVP.data.Pojo;
import com.faishalbadri.rebuildmvpmovie.MVP.repositories.MainActivityDataResource.MainActivityGetCallback;
import com.faishalbadri.rebuildmvpmovie.MVP.repositories.MainActivityRepositories;
import java.util.List;

/**
 * Created by faishal on 9/27/17.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

  MainActivityContract.View view;
  private MainActivityRepositories mainActivityRepositories;

  public MainActivityPresenter(MainActivityRepositories mainActivityRepositories) {
    this.mainActivityRepositories = mainActivityRepositories;
  }


  @Override
  public void onAttachView(MainActivityContract.View view) {
    this.view = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getData() {
    mainActivityRepositories.getMainActivityList(new MainActivityGetCallback() {
      @Override
      public void onSucces(List<Pojo.KategoriBean>data,String msg) {
        view.onSucces(data,msg);
      }

      @Override
      public void onError(String msg) {
        view.onError(msg);
      }

      @Override
      public void onDataEmpty(String msg) {
        view.onError(msg);
      }
    });
  }
}
