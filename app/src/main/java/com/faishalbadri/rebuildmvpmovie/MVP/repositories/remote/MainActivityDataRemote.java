package com.faishalbadri.rebuildmvpmovie.MVP.repositories.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.rebuildmvpmovie.MVP.data.Pojo;
import com.faishalbadri.rebuildmvpmovie.MVP.util.Server;
import com.faishalbadri.rebuildmvpmovie.MVP.repositories.MainActivityDataResource;
import com.faishalbadri.rebuildmvpmovie.R;
import com.google.gson.Gson;

/**
 * Created by faishal on 9/27/17.
 */

public class MainActivityDataRemote implements MainActivityDataResource {

  private Context context;
  private final static String URL = Server.BASE_URL + "getTbIsiNew.php";

  public MainActivityDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getMainActivityList(@NonNull final MainActivityGetCallback mainActivityGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);

    StringRequest stringRequest = new StringRequest(Request.Method.GET, String.valueOf(URL),
        new Listener<String>() {
          @Override
          public void onResponse(String response) {
            Log.i("response", response);
            Pojo pojo = new Gson().fromJson(response, Pojo.class);

            if (pojo == null) {
              mainActivityGetCallback.onDataEmpty(context.getString(R.string.onDataEmpty));
            } else {
              mainActivityGetCallback.onSucces(pojo.getKategori(), context.getString(R.string.onSucces));
            }
          }
        }, new ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        mainActivityGetCallback.onError(String.valueOf(error));
      }
    });

    requestQueue.add(stringRequest);
  }
}
