package com.talkingdata.dmpplus.controller.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.talkingdata.dmpplus.dao.entity.AppInfo;

public class AppInfoResp extends AppBaseInfoResp {
  private AppInfoMediaResp media;
  private List<AppInfoIntroResp> introduction;
  private List<AppInfoCustomResp> customs;
  private List<AppInfoRelatedAppResp> relatedApps;

  public AppInfoResp() {
    super();
  }

  public AppInfoResp(AppInfo appInfo) {
    super(appInfo.getId(), appInfo.getName(), appInfo.getNameEn(), appInfo.getVersion(), appInfo.getRating(), appInfo
        .getSupplier(), appInfo.getIconUrl(), appInfo.getLogoUrl(), appInfo.getTag(), appInfo.getPricing(), appInfo
        .getTrial(), appInfo.getAccessDate(), appInfo.getDeploy(), appInfo.getDescription());
  }

  public AppInfoResp(String id, String name, String nameEn, String version, Integer rating, String supplier,
      String iconUrl, String logoUrl, String tag, String pricing, String trial, Date accessDate, String deploy,
      String desc) {
    super(id, name, nameEn, version, rating, supplier, iconUrl, logoUrl, tag, pricing, trial, accessDate, deploy, desc);
  }

  public AppInfoResp(String id, String name, String nameEn, String version, Integer rating, String supplier,
      String iconUrl, String logoUrl, String bussinessType, String tag, String pricing, String trial, Date accessDate,
      String deploy, String desc, AppInfoMediaResp media, List<AppInfoIntroResp> introduction,
      List<AppInfoCustomResp> customs, List<AppInfoRelatedAppResp> relatedApps) {
    super(id, name, nameEn, version, rating, supplier, iconUrl, logoUrl, tag, pricing, trial, accessDate, deploy, desc);
    this.media = media;
    this.introduction = introduction;
    this.customs = customs;
    this.relatedApps = relatedApps;
  }

  public AppInfoMediaResp getMedia() {
    if (media == null) {
      media = new AppInfoMediaResp();
    }
    return media;
  }

  public void setMedia(AppInfoMediaResp media) {
    this.media = media;
  }

  public List<AppInfoIntroResp> getIntroduction() {
    if (introduction == null) {
      introduction = new ArrayList<AppInfoIntroResp>();
    }
    return introduction;
  }

  public List<AppInfoCustomResp> getCustoms() {
    if (customs == null) {
      customs = new ArrayList<AppInfoCustomResp>();
    }
    return customs;
  }

  public List<AppInfoRelatedAppResp> getRelatedApps() {
    if (relatedApps == null) {
      relatedApps = new ArrayList<AppInfoRelatedAppResp>();
    }
    return relatedApps;
  }

}
