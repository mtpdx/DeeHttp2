package com.deepbay.deehttp2;

/**
 * Created by 孙应恒 on 2018/1/31.
 * Description:
 */

public class HttpConstants {
  public static final String BASE_URL = "http://api.deepbaytech.com";
  public static final String MOBILE = "/mobile/api";
  public static final String SHOP = "/shop/api";
  public static final String COMMUNITY = "/community/api";
  public static final String VERSION = "/v0.0.1/";

  public static final String MOBILE_URL = BASE_URL+MOBILE+VERSION;
  public static final String SHOP_URL = BASE_URL+SHOP+VERSION;
  public static final String COMMUNITY_URL = BASE_URL+COMMUNITY+VERSION;

  public static final int CONNECT_TIMEOUT = 10;
  public static final int READ_TIMEOUT = 10;

}
