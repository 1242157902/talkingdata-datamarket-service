package com.talkingdata.dmpplus.controller.response;

public class AppInfoRelatedAppResp {
  private String id;
  private String name;
  private String nameEn;
  private String logoUrl;
  private int rating;

  public AppInfoRelatedAppResp() {
    super();
  }

  public AppInfoRelatedAppResp(String id, String name, String nameEn, String logoUrl, int rating) {
    super();
    this.id = id;
    this.name = name;
    this.nameEn = nameEn;
    this.logoUrl = logoUrl;
    this.rating = rating;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNameEn() {
    return nameEn;
  }

  public void setNameEn(String nameEn) {
    this.nameEn = nameEn;
  }

  public String getLogoUrl() {
    return logoUrl;
  }

  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

}
