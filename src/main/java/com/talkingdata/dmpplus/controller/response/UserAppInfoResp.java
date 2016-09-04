package com.talkingdata.dmpplus.controller.response;

import java.util.Date;
import java.util.List;

import com.talkingdata.dmpplus.dao.entity.AppInfo;

public class UserAppInfoResp extends AppBaseInfoResp {
  private Date purchaseDate;
  private Date expireDate;
  private int status;

  public UserAppInfoResp() {
    super();
  }

  public UserAppInfoResp(AppInfo appInfo) {
    super(appInfo);
  }

  public UserAppInfoResp(String id, String name, String nameEn, String version, Integer rating, String supplier,
      String iconUrl, String logoUrl, String tag, String pricing, String trial, Date accessDate, String deploy,
      String desc, List<AppInfoBusinessResp> businessType) {
    super(id, name, nameEn, version, rating, supplier, iconUrl, logoUrl, tag, pricing, trial, accessDate, deploy, desc,
        businessType);
  }

  public UserAppInfoResp(String id, String name, String nameEn, String version, Integer rating, String supplier,
      String iconUrl, String logoUrl, String tag, String pricing, String trial, Date accessDate, String deploy,
      String desc) {
    super(id, name, nameEn, version, rating, supplier, iconUrl, logoUrl, tag, pricing, trial, accessDate, deploy, desc);
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

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

}
