package com.deepbay.deehttp;

import android.content.Intent;
import android.widget.Toast;

/**
 * Created by 孙应恒 on 2018/1/31.
 * Description:
 */

class DeeApiException extends RuntimeException {
  public DeeApiException(int resultCode, String resultMessage) {
    super(getApiExceptionMessage(resultCode, resultMessage));
  }

  public DeeApiException(int resultCode) {
    super(getApiExceptionMessage(resultCode));
  }

  private static String getApiExceptionMessage(int resultCode) {
    switch (resultCode) {
      case 1:
        break;
      case 2:
        break;
      case 3:
        break;
      case 10:
        break;
      default:
        break;
    }
    return "msg";
  }

  private static String getApiExceptionMessage(int resultCode, String resultMessage) {
    boolean flag = false;
    switch (resultCode) {
      case 1:
        flag =true;
        break;
      case 2:
        flag = true;
        break;
      case 3:
        break;
      case 10:
        DayuApp.getContext().startActivity(new Intent(DayuApp.getContext(),LoginActivity.class));
        break;
      default:
        break;
    }
    if (flag){
      Toast.makeText(DayuApp.getContext(),resultMessage,Toast.LENGTH_SHORT).show();
    }
    return resultMessage;
  }

  //private static Context getContext(){
  //  Context context = null;
  //  Class clazz = null;
  //  try {
  //    clazz = Class.forName("com.deepbay.deehttp.DayuApp");
  //    Object instance = clazz.newInstance();
  //    Method getContext = instance.getClass().getMethod("getContext");
  //    context = (Context) getContext.invoke(instance);
  //  } catch (Exception e) {
  //    e.printStackTrace();
  //  }
  //
  //  return context;
  //}
}
