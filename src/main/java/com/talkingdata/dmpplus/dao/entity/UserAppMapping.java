package com.talkingdata.dmpplus.dao.entity;

import java.util.Date;

public class UserAppMapping {
  private String id;

  private String userId;

  private String appId;

  private Date purchaseDate;

  private Date expireDate;

  private Integer status;

  public UserAppMapping(String id, String userId, String appId, Date purchaseDate, Date expireDate, Integer status) {
    this.id = id;
    this.userId = userId;
    this.appId = appId;
    this.purchaseDate = purchaseDate;
    this.expireDate = expireDate;
    this.status = status;
  }

  public UserAppMapping() {
    super();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public Date getPurchaseDate() {
    return purchaseDate;
  }

  public void setPurchaseDate(Date purchaseDate) {
    this.purchaseDate = purchaseDate;
  }

  public Date getExpireDate() {
    return expireDate;
  }

  public void setExpireDate(Date expireDate) {
    this.expireDate = expireDate;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }
}
