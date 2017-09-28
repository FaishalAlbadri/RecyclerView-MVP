package com.faishalbadri.rebuildmvpmovie.MVP.repositories;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 9/27/17.
 */

public class MainActivityRepositories implements MainActivityDataResource {

  private MainActivityDataResource mainActivityDataRemote;

  public MainActivityRepositories(
      MainActivityDataResource mainActivityDataRemote) {
    this.mainActivityDataRemote = mainActivityDataRemote;
  }

  @Override
  public void getMainActivityList(
      @NonNull MainActivityGetCallback mainActivityGetCallback) {
    mainActivityDataRemote.getMainActivityList(mainActivityGetCallback);
  }
}
