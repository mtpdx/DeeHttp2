package com.deepbay.deehttp2;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 孙应恒 on 2018/1/31.
 * Description:
 */

public class DeeInterceptor implements Interceptor{
  private String headerToken = "";

  public DeeInterceptor() {
  }

  public DeeInterceptor(String headerToken) {
    this.headerToken = headerToken;
  }

  @Override public Response intercept(Chain chain) throws IOException {
    Request original = chain.request();
    Request request = original.newBuilder()
        .addHeader("dpbay-token", headerToken)
        .method(original.method(), original.body())
        .build();
    return chain.proceed(request);
  }
}
