package com.talkingdata.dmpplus.dao.entity;

public class AppAccessInfo {
  private String appId;

  private Integer authType;

  private String redirectUrl;

  public AppAccessInfo(String appId, Integer authType, String redirectUrl) {
    this.appId = appId;
    this.authType = authType;
    this.redirectUrl = redirectUrl;
  }

  public AppAccessInfo() {
    super();
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public Integer getAuthType() {
    return authType;
  }

  public void setAuthType(Integer authType) {
    this.authType = authType;
  }

  public String getRedirectUrl() {
    return redirectUrl;
  }

  public void setRedirectUrl(String redirectUrl) {
    this.redirectUrl = redirectUrl == null ? null : redirectUrl.trim();
  }
}
