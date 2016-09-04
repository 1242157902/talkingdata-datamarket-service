package com.talkingdata.dmpplus.dao.entity;

import java.util.Date;

public class AppInfo {
  private String id;

  private String name;

  private String nameEn;

  private String version;

  private Integer rating;

  private String supplier;

  private String iconUrl;

  private String logoUrl;

  private String tag;

  private String pricing;

  private String trial;

  private Date accessDate;

  private String deploy;

  private String description;

  public AppInfo(String id, String name, String nameEn, String version, Integer rating, String supplier,
      String iconUrl, String logoUrl, String tag, String pricing, String trial, Date accessDate, String deploy,
      String description) {
    this.id = id;
    this.name = name;
    this.nameEn = nameEn;
    this.version = version;
    this.rating = rating;
    this.supplier = supplier;
    this.iconUrl = iconUrl;
    this.logoUrl = logoUrl;
    this.tag = tag;
    this.pricing = pricing;
    this.trial = trial;
    this.accessDate = accessDate;
    this.deploy = deploy;
    this.description = description;
  }

  public AppInfo() {
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

  public String getNameEn() {
    return nameEn;
  }

  public void setNameEn(String nameEn) {
    this.nameEn = nameEn == null ? null : nameEn.trim();
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version == null ? null : version.trim();
  }

  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  public String getSupplier() {
    return supplier;
  }

  public void setSupplier(String supplier) {
    this.supplier = supplier == null ? null : supplier.trim();
  }

  public String getIconUrl() {
    return iconUrl;
  }

  public void setIconUrl(String iconUrl) {
    this.iconUrl = iconUrl == null ? null : iconUrl.trim();
  }

  public String getLogoUrl() {
    return logoUrl;
  }

  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl == null ? null : logoUrl.trim();
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag == null ? null : tag.trim();
  }

  public String getPricing() {
    return pricing;
  }

  public void setPricing(String pricing) {
    this.pricing = pricing == null ? null : pricing.trim();
  }

  public String getTrial() {
    return trial;
  }

  public void setTrial(String trial) {
    this.trial = trial == null ? null : trial.trim();
  }

  public Date getAccessDate() {
    return accessDate;
  }

  public void setAccessDate(Date accessDate) {
    this.accessDate = accessDate;
  }

  public String getDeploy() {
    return deploy;
  }

  public void setDeploy(String deploy) {
    this.deploy = deploy == null ? null : deploy.trim();
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description == null ? null : description.trim();
  }
}
