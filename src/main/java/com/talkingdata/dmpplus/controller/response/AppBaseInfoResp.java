package com.talkingdata.dmpplus.controller.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.talkingdata.dmpplus.dao.entity.AppInfo;

public class AppBaseInfoResp extends AppInfo {
  private List<AppInfoBusinessResp> businessType;

  public AppBaseInfoResp() {
    super();
  }

  public AppBaseInfoResp(AppInfo appInfo) {
    super(appInfo.getId(), appInfo.getName(), appInfo.getNameEn(), appInfo.getVersion(), appInfo.getRating(), appInfo
        .getSupplier(), appInfo.getIconUrl(), appInfo.getLogoUrl(), appInfo.getTag(), appInfo.getPricing(), appInfo
        .getTrial(), appInfo.getAccessDate(), appInfo.getDeploy(), appInfo.getDescription());
  }

  public AppBaseInfoResp(String id, String name, String nameEn, String version, Integer rating, String supplier,
      String iconUrl, String logoUrl, String tag, String pricing, String trial, Date accessDate, String deploy,
      String desc) {
    super(id, name, nameEn, version, rating, supplier, iconUrl, logoUrl, tag, pricing, trial, accessDate, deploy, desc);
  }

  public AppBaseInfoResp(String id, String name, String nameEn, String version, Integer rating, String supplier,
      String iconUrl, String logoUrl, String tag, String pricing, String trial, Date accessDate, String deploy,
      String desc, List<AppInfoBusinessResp> businessType) {
    super(id, name, nameEn, version, rating, supplier, iconUrl, logoUrl, tag, pricing, trial, accessDate, deploy, desc);
    this.businessType = businessType;
  }

  public List<AppInfoBusinessResp> getBusinessType() {
    if (businessType == null) {
      businessType = new ArrayList<AppInfoBusinessResp>();
    }
    return businessType;
  }

  public void setBusinessType(List<AppInfoBusinessResp> businessType) {
    this.businessType = businessType;
  }

}
