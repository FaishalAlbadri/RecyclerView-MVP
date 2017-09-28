package com.faishalbadri.rebuildmvpmovie.MVP.ui;

import com.faishalbadri.rebuildmvpmovie.MVP.Base.BasePresenter;
import com.faishalbadri.rebuildmvpmovie.MVP.data.Pojo;
import java.util.List;

/**
 * Created by faishal on 9/26/17.
 */

public class MainActivityContract {

  public interface View {
    void onSucces(List<Pojo.KategoriBean> data,String msg);
    void onError(String msg);
  }

  public interface Presenter extends BasePresenter<View>{
    void getData();
  }

}
