package com.deepbay.deehttp;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by 孙应恒 on 2018/1/31.
 * Description:
 */

public class DayuApp extends Application {
  private static Context context;

  public static Context getContext() {
    return context;
  }

  @Override public void onCreate() {
    super.onCreate();
    context = this.getApplicationContext();
  }

  public static int getAppVersionCode() {
    Context context = getContext();
    try {
      PackageInfo
          info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
      return info.versionCode;
    } catch (PackageManager.NameNotFoundException e) {
      e.printStackTrace();
    }
    return 1;
  }

}
