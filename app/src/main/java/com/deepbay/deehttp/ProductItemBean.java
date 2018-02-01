package com.deepbay.deehttp;

import java.io.Serializable;

/**
 * Created by 孙应恒 on 2018/1/31.
 * Description:
 */

public class ProductItemBean implements Serializable {

  private int id;

  private String pname;

  private String pfrom;

  private String pfromId;

  private String fromUrl;

  private String detailUrl;

  private String detailAppUrl;

  private String image;

  private String htmlUrl;

  public String getHtmlUrl() {
    return htmlUrl;
  }

  public void setHtmlUrl(String htmlUrl) {
    this.htmlUrl = htmlUrl;
  }

  private String pfromImage;

  private int type;

  private String typeVal;

  private Number price;

  private String symbol;

  private String description;

  private String remarkCount;

  private int goodCount;

  private int brandId;

  private int familyId;

  private int categoryId;

  private int amountType;

  private double amountMoney;

  private String platformId;

  public String getPlatformId() {
    return platformId;
  }

  public void setPlatformId(String platformId) {
    this.platformId = platformId;
  }

  public int getAmountType() {
    return amountType;
  }

  public void setAmountType(int amountType) {
    this.amountType = amountType;
  }

  public double getAmountMoney() {
    return amountMoney;
  }

  public void setAmountMoney(double amountMoney) {
    this.amountMoney = amountMoney;
  }

  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  public int getBrandId() {
    return brandId;
  }

  public void setBrandId(int brandId) {
    this.brandId = brandId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDetailAppUrl() {
    return detailAppUrl;
  }

  public void setDetailAppUrl(String detailAppUrl) {
    this.detailAppUrl = detailAppUrl;
  }

  public String getDetailUrl() {
    return detailUrl;
  }

  public void setDetailUrl(String detailUrl) {
    this.detailUrl = detailUrl;
  }

  public String getFromUrl() {
    return fromUrl;
  }

  public void setFromUrl(String fromUrl) {
    this.fromUrl = fromUrl;
  }

  public int getFamilyId() {
    return familyId;
  }

  public void setFamilyId(int familyId) {
    this.familyId = familyId;
  }

  public int getGoodCount() {
    return goodCount;
  }

  public void setGoodCount(int goodCount) {
    this.goodCount = goodCount;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getPfrom() {
    return pfrom;
  }

  public void setPfrom(String pfrom) {
    this.pfrom = pfrom;
  }

  public String getPfromId() {
    return pfromId;
  }

  public void setPfromId(String pfromId) {
    this.pfromId = pfromId;
  }

  public String getPfromImage() {
    return pfromImage;
  }

  public void setPfromImage(String pfromImage) {
    this.pfromImage = pfromImage;
  }

  public String getPname() {
    return pname;
  }

  public void setPname(String pname) {
    this.pname = pname;
  }

  public Number getPrice() {
    return price;
  }

  public void setPrice(Number price) {
    this.price = price;
  }

  public String getRemarkCount() {
    return remarkCount;
  }

  public void setRemarkCount(String remarkCount) {
    this.remarkCount = remarkCount;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public String getTypeVal() {
    return typeVal;
  }

  public void setTypeVal(String typeVal) {
    this.typeVal = typeVal;
  }

}
