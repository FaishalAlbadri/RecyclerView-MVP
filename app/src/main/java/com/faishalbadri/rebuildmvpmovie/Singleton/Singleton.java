package com.faishalbadri.rebuildmvpmovie.Singleton;

/**
 * Created by faishal on 9/27/17.
 */

public class Singleton {

  private static Singleton mInstance = null;

  private String mString;

  private Singleton(){
    mString = "Hello";
  }

  public static Singleton getInstance(){
    if(mInstance == null) {
      mInstance = new Singleton();
    }
    return mInstance;
  }

  public String getString(){
    return this.mString;
  }

  public void setString(String value){
    mString = value;
  }
}