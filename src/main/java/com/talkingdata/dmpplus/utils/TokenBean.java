package com.talkingdata.dmpplus.utils;

public class TokenBean {
  private String username;
  private String ip;
  private Long expiredTime;

  public TokenBean() {
    super();
    // TODO Auto-generated constructor stub
  }

  public TokenBean(String username, String ip, Long expiredTime) {
    super();
    this.username = username;
    this.ip = ip;
    this.expiredTime = expiredTime;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public Long getExpiredTime() {
    return expiredTime;
  }

  public void setExpiredTime(Long expiredTime) {
    this.expiredTime = expiredTime;
  }

}
