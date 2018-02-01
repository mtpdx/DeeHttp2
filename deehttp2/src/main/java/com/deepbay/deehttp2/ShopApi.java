package com.deepbay.deehttp2;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by 孙应恒 on 2018/1/31.
 * Description:
 */

public interface ShopApi {
  @GET("ordersAll?pageId=1") Observable<DeeResponse>getOrderAll();
}
