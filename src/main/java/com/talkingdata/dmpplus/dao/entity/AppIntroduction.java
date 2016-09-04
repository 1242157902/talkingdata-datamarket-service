package com.talkingdata.dmpplus.dao.entity;

public class AppIntroduction {
  private String id;

  private String appId;

  private String title;

  private String context;

  public AppIntroduction(String id, String appId, String title, String context) {
    this.id = id;
    this.appId = appId;
    this.title = title;
    this.context = context;
  }

  public AppIntroduction() {
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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title == null ? null : title.trim();
  }

  public String getContext() {
    return context;
  }

  public void setContext(String context) {
    this.context = context == null ? null : context.trim();
  }
}
