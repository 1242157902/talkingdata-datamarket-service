package com.talkingdata.dmpplus.dao.entity;

import java.util.Date;

public class UserInfo {
  private String id;

  private String account;

  private String password;

  private Boolean status;

  private Date registerTime;

  private Date loginTime;

  private String pictureUrl;

  private String company;

  private String name;

  private String phone;

  private String qq;

  private String accessToken;

  public UserInfo(String id, String account, String password, Boolean status, Date registerTime, Date loginTime,
      String pictureUrl, String company, String name, String phone, String qq, String accessToken) {
    this.id = id;
    this.account = account;
    this.password = password;
    this.status = status;
    this.registerTime = registerTime;
    this.loginTime = loginTime;
    this.pictureUrl = pictureUrl;
    this.company = company;
    this.name = name;
    this.phone = phone;
    this.qq = qq;
    this.accessToken = accessToken;
  }

  public UserInfo() {
    super();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account == null ? null : account.trim();
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password == null ? null : password.trim();
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  public Date getRegisterTime() {
    return registerTime;
  }

  public void setRegisterTime(Date registerTime) {
    this.registerTime = registerTime;
  }

  public Date getLoginTime() {
    return loginTime;
  }

  public void setLoginTime(Date loginTime) {
    this.loginTime = loginTime;
  }

  public String getPictureUrl() {
    return pictureUrl;
  }

  public void setPictureUrl(String pictureUrl) {
    this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company == null ? null : company.trim();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name == null ? null : name.trim();
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone == null ? null : phone.trim();
  }

  public String getQq() {
    return qq;
  }

  public void setQq(String qq) {
    this.qq = qq == null ? null : qq.trim();
  }

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken == null ? null : accessToken.trim();
  }

}
