package com.talkingdata.dmpplus.dao.entity;

public class AppBussinessMappingKey {
  private String appId;

  private String businessId;

  public AppBussinessMappingKey(String appId, String businessId) {
    this.appId = appId;
    this.businessId = businessId;
  }

  public AppBussinessMappingKey() {
    super();
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public String getBusinessId() {
    return businessId;
  }

  public void setBusinessId(String businessId) {
    this.businessId = businessId;
  }
}
