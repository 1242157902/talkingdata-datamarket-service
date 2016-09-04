package com.talkingdata.dmpplus.controller.response;

public class AppInfoCustomResp {
  private String logoUrl;
  private String name;

  public AppInfoCustomResp() {
    super();
  }

  public AppInfoCustomResp(String logoUrl, String name) {
    super();
    this.logoUrl = logoUrl;
    this.name = name;
  }

  public String getLogoUrl() {
    return logoUrl;
  }

  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
