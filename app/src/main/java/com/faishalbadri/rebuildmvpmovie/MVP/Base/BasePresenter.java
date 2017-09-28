package com.faishalbadri.rebuildmvpmovie.MVP.Base;

/**
 * Created by faishal on 9/27/17.
 */

public interface BasePresenter<T> {
  void onAttachView(T view);
  void onDettachView();
}
