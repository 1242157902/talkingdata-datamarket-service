package com.talkingdata.dmpplus.dao.entity;

public class BusinessInfo {
  private String id;

  private String name;

  public BusinessInfo(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public BusinessInfo() {
    super();
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
    this.name = name == null ? null : name.trim();
  }
}
