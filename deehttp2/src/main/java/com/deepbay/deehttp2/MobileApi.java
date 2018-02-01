package com.deepbay.deehttp2;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by 孙应恒 on 2018/1/31.
 * Description:
 */

public interface MobileApi {
  @GET("panic-buy") Observable<DeeResponse> getPanicBuy();

  @GET("family/{categoryId}/detail/{pageId}") Observable<DeeResponse> getCatDetail(
      @Path("categoryId") long cid, @Path("pageId") int pid, @Query("sortId") int sid,
      @Query("sortType") int st);
}
