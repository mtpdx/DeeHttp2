package com.deepbay.deehttp2;

/**
 * Created by 孙应恒 on 2018/2/1.
 * Description:
 */

public class DeeFun<T> {
  private String flag;
  private T deeData;

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public T getDeeData() {
    return deeData;
  }

  public void setDeeData(T deeData) {
    this.deeData = deeData;
  }
}
