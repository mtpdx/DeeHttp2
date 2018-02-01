package com.deepbay.deehttp2;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 孙应恒 on 2018/1/31.
 * Description:
 */

public class DeeApiManager {
  private MobileApi mobileApi;
  private ShopApi shopApi;
  private CommunityApi communityApi;
  private OkHttpClient mClient;

  public static DeeApiManager getInstence() {
    return SingletonHolder.INSTANCE;
  }

  private static class SingletonHolder {
    private static final DeeApiManager INSTANCE = new DeeApiManager();
  }

  public DeeApiManager() {
    if (mClient == null){
      mClient = new OkHttpClient.Builder().addInterceptor(new DeeInterceptor())
          .connectTimeout(HttpConstants.CONNECT_TIMEOUT, TimeUnit.SECONDS)
          .readTimeout(HttpConstants.READ_TIMEOUT, TimeUnit.SECONDS)
          .build();
    }
  }

  /**
   * 登录成功时,首次请求调用 -- headerToken
   * 退出登录,首次请求调用 -- ""
   * @param headerToken
   * @return
   */
  public DeeApiManager genTokenClient(String headerToken) {
    mClient = new OkHttpClient.Builder().addInterceptor(new DeeInterceptor(headerToken))
          .connectTimeout(HttpConstants.CONNECT_TIMEOUT, TimeUnit.SECONDS)
          .readTimeout(HttpConstants.READ_TIMEOUT, TimeUnit.SECONDS)
          .build();
    mobileApi = null;
    shopApi = null;
    communityApi = null;
    return this;
  }

  public MobileApi getMobile() {
    if (mobileApi == null) {
      Retrofit retrofit = new Retrofit.Builder().client(mClient)
          .baseUrl(HttpConstants.MOBILE_URL)
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .addConverterFactory(GsonConverterFactory.create())
          .build();
      mobileApi = retrofit.create(MobileApi.class);
    }
    return mobileApi;
  }

  public ShopApi getShop() {
    if (shopApi == null) {
      Retrofit retrofit = new Retrofit.Builder().client(mClient)
          .baseUrl(HttpConstants.SHOP_URL)
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .addConverterFactory(GsonConverterFactory.create())
          .build();
      shopApi = retrofit.create(ShopApi.class);
    }
    return shopApi;
  }

  public CommunityApi geCommunity() {
    if (communityApi == null) {
      Retrofit retrofit = new Retrofit.Builder().client(mClient)
          .baseUrl(HttpConstants.COMMUNITY_URL)
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .addConverterFactory(GsonConverterFactory.create())
          .build();
      communityApi = retrofit.create(CommunityApi.class);
    }
    return communityApi;
  }
}
