package com.talkingdata.dmpplus.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.talkingdata.dmpplus.constant.DmpPlusConstant;
import com.talkingdata.dmpplus.controller.response.AppAccessResp;
import com.talkingdata.dmpplus.controller.response.BaseResp;
import com.talkingdata.dmpplus.controller.response.MyAppOverallResp;
import com.talkingdata.dmpplus.controller.response.MyAppResp;
import com.talkingdata.dmpplus.controller.response.UserAppInfoResp;
import com.talkingdata.dmpplus.dao.entity.AppAccessInfo;
import com.talkingdata.dmpplus.service.AppInfoService;
import com.talkingdata.dmpplus.service.UserAppsService;

@Controller
@RequestMapping("/myapps")
public class CustomerController {

  private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

  @Autowired
  private UserAppsService userAppsService;

  @Autowired
  private AppInfoService appInfoService;

  /**
   * 获取用户购买app列表
   *
   * @param req
   * @return
   */
  @RequestMapping(value = "/{username}", method = {RequestMethod.GET})
  @ResponseBody
  public BaseResp<MyAppResp> getUserApps(@PathVariable String username) {
    MyAppResp myAppResp = new MyAppResp();
    List<UserAppInfoResp> apps = userAppsService.getUserApps(username);
    myAppResp.setApps(apps);
    MyAppOverallResp overall = new MyAppOverallResp();
    overall.setAllApp(appInfoService.getAppCount());
    overall.setNewApp(appInfoService.getNewAppCount());
    overall.setRecommendApp(appInfoService.getRecommendAppCount());
    myAppResp.setOverall(overall);
    return new BaseResp<MyAppResp>(myAppResp);
  }

  /**
   * 获取用户购买app列表
   *
   * @param req
   * @return
   */
  @RequestMapping(value = "/access/{appId}", method = {RequestMethod.GET})
  @ResponseBody
  public BaseResp<AppAccessResp> getAppAccess(@PathVariable String appId) {
    // TODO: check the user has the right of this app
    AppAccessResp access = new AppAccessResp();
    AppAccessInfo appAccessInfo = userAppsService.getAppAccessByAppId(appId);
    if (DmpPlusConstant.APP_ACCESS_AUTH_ANONYMOUS == appAccessInfo.getAuthType()) {
      access.setUrl(appAccessInfo.getRedirectUrl());
    }
    return new BaseResp<AppAccessResp>(access);
  }
}
