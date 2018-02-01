package com.deepbay.deehttp2;

import android.support.annotation.Keep;
import com.google.gson.annotations.SerializedName;

/**
 * Created by 孙应恒 on 2018/1/31.
 * Description:
 */
@Keep
public class DeeResponse<T> {
  private int id;
  private long updateTime;
  private int state;
  private String stateSmg;
  @SerializedName(value="data", alternate="items")
  private T data;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public long getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(long updateTime) {
    this.updateTime = updateTime;
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public String getStateSmg() {
    return stateSmg;
  }

  public void setStateSmg(String stateSmg) {
    this.stateSmg = stateSmg;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  @Override public String toString() {
    return "DeeResponse{"
        + "id="
        + id
        + ", updateTime="
        + updateTime
        + ", state="
        + state
        + ", stateSmg='"
        + stateSmg
        + '\''
        + ", data="
        + data
        + '}';
  }
}
