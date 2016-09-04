package com.talkingdata.dmpplus.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.talkingdata.dmpplus.constant.DmpPlusConstant;
import com.talkingdata.dmpplus.controller.response.AppBaseInfoResp;
import com.talkingdata.dmpplus.controller.response.AppInfoBusinessResp;
import com.talkingdata.dmpplus.controller.response.AppInfoCustomResp;
import com.talkingdata.dmpplus.controller.response.AppInfoIntroResp;
import com.talkingdata.dmpplus.controller.response.AppInfoRelatedAppResp;
import com.talkingdata.dmpplus.controller.response.AppInfoResp;
import com.talkingdata.dmpplus.controller.response.AppResp;
import com.talkingdata.dmpplus.controller.response.BaseResp;
import com.talkingdata.dmpplus.dao.entity.AppInfo;
import com.talkingdata.dmpplus.dao.entity.AppIntroduction;
import com.talkingdata.dmpplus.dao.entity.AppMediaInfo;
import com.talkingdata.dmpplus.dao.entity.BusinessInfo;
import com.talkingdata.dmpplus.service.AppInfoService;
import com.talkingdata.dmpplus.service.UserAppsService;

@Controller
@RequestMapping("/apps")
public class AppController {

  private final Logger logger = LoggerFactory.getLogger(AppController.class);

  @Autowired
  private AppInfoService appInfoService;

  @Autowired
  private UserAppsService userAppsService;

  /**
   * 获取所有app列表
   *
   * @return
   */
  @RequestMapping(method = {RequestMethod.GET})
  @ResponseBody
  public BaseResp<AppResp> getApps() {
    List<AppBaseInfoResp> appsResp = new ArrayList<AppBaseInfoResp>();
    List<AppInfo> apps = appInfoService.getAllApps();
    if (!CollectionUtils.isEmpty(apps)) {
      for (AppInfo app : apps) {
        AppBaseInfoResp appBaseInfoResp = new AppBaseInfoResp(app);
        List<BusinessInfo> bussiness = appInfoService.getAppBusinessInfoById(app.getId());
        if (!CollectionUtils.isEmpty(bussiness)) {
          for (BusinessInfo bus : bussiness) {
            appBaseInfoResp.getBusinessType().add(new AppInfoBusinessResp(bus.getId(), bus.getName()));
          }
        }
        appsResp.add(appBaseInfoResp);
      }
    }
    return new BaseResp<AppResp>(new AppResp(appsResp));
  }

  /**
   * 根据id获取app详细信息
   *
   * @return
   */
  @RequestMapping(value = "/{appId}", method = {RequestMethod.GET})
  @ResponseBody
  public BaseResp<AppInfoResp> getAppInfo(@PathVariable String appId) {
    AppInfo app = appInfoService.getAppInfoById(appId);
    AppInfoResp appInfo = new AppInfoResp(app);
    // business
    List<BusinessInfo> bussiness = appInfoService.getAppBusinessInfoById(app.getId());
    if (!CollectionUtils.isEmpty(bussiness)) {
      for (BusinessInfo bus : bussiness) {
        appInfo.getBusinessType().add(new AppInfoBusinessResp(bus.getId(), bus.getName()));
      }
    }
    // media
    List<AppMediaInfo> media = appInfoService.getAppMediaByAppId(appId);
    for (AppMediaInfo appMedia : media) {
      if (appMedia.getMediaType() == DmpPlusConstant.APP_MEDIA_VEDIO) {
        appInfo.getMedia().getVideoUrl().add(appMedia.getMediaUrl());
      } else if (appMedia.getMediaType() == DmpPlusConstant.APP_MEDIA_IMAGE) {
        appInfo.getMedia().getImgUrl().add(appMedia.getMediaUrl());
      } else if (appMedia.getMediaType() == DmpPlusConstant.APP_MEDIA_MAINCUSTOM) {
        appInfo.getCustoms().add(new AppInfoCustomResp(appMedia.getMediaUrl(), ""));
      }
    }
    // introduction
    List<AppIntroduction> introductions = appInfoService.getIntroductionByAppId(appId);
    for (AppIntroduction introduction : introductions) {
      AppInfoIntroResp introResp = new AppInfoIntroResp();
      introResp.setTitle(introduction.getTitle());
      introResp.setDetails(introduction.getContext());
      appInfo.getIntroduction().add(introResp);
    }

    // customs
    // List<UserInfo> paiedUsers = userAppsService.getPurchasedUser(appId);
    // for (UserInfo paiedUser : paiedUsers) {
    // AppInfoCustomResp custom = new AppInfoCustomResp();
    // custom.setName(paiedUser.getCompany());
    // custom.setLogoUrl(paiedUser.getPictureUrl());
    // appInfo.getCustoms().add(custom);
    // }

    // relatedApps
    List<AppInfo> relatedAppsInfo = appInfoService.getAppsBySupplier(app.getSupplier());
    for (AppInfo r : relatedAppsInfo) {
      AppInfoRelatedAppResp relatedApp =
          new AppInfoRelatedAppResp(r.getId(), r.getName(), r.getNameEn(), r.getLogoUrl(), r.getRating());
      appInfo.getRelatedApps().add(relatedApp);
    }

    return new BaseResp<AppInfoResp>(appInfo);
  }
}
