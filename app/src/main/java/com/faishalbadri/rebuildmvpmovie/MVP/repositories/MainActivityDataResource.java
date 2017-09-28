package com.faishalbadri.rebuildmvpmovie.MVP.repositories;

import android.support.annotation.NonNull;
import com.faishalbadri.rebuildmvpmovie.MVP.data.Pojo;
import java.util.List;

/**
 * Created by faishal on 9/27/17.
 */

public interface MainActivityDataResource {

  interface MainActivityGetCallback{
    void onSucces(List<Pojo.KategoriBean> data, String msg);
    void onError(String msg);
    void onDataEmpty(String msg);
  }

  void getMainActivityList(@NonNull MainActivityGetCallback mainActivityGetCallback);
}
