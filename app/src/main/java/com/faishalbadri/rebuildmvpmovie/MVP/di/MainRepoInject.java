package com.faishalbadri.rebuildmvpmovie.MVP.di;

import android.content.Context;
import com.faishalbadri.rebuildmvpmovie.MVP.repositories.MainActivityRepositories;
import com.faishalbadri.rebuildmvpmovie.MVP.repositories.remote.MainActivityDataRemote;

/**
 * Created by faishal on 9/27/17.
 */

public class MainRepoInject {
  public static MainActivityRepositories provideToMainRepo(Context context){
    return new MainActivityRepositories(new MainActivityDataRemote(context));
  }
}
