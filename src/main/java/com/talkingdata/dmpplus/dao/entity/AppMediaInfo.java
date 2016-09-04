package com.talkingdata.dmpplus.dao.entity;

public class AppMediaInfo {
  private String id;

  private String appId;

  private String mediaUrl;

  private Integer mediaType;

  public AppMediaInfo(String id, String appId, String mediaUrl, Integer mediaType) {
    this.id = id;
    this.appId = appId;
    this.mediaUrl = mediaUrl;
    this.mediaType = mediaType;
  }

  public AppMediaInfo() {
    super();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public String getMediaUrl() {
    return mediaUrl;
  }

  public void setMediaUrl(String mediaUrl) {
    this.mediaUrl = mediaUrl == null ? null : mediaUrl.trim();
  }

  public Integer getMediaType() {
    return mediaType;
  }

  public void setMediaType(Integer mediaType) {
    this.mediaType = mediaType;
  }
}
