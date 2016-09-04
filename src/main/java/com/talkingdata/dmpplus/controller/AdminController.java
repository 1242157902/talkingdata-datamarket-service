package com.talkingdata.dmpplus.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.talkingdata.dmpplus.constant.DmpPlusConstant;
import com.talkingdata.dmpplus.controller.response.BaseResp;
import com.talkingdata.dmpplus.service.AppInfoService;

@Controller
@RequestMapping("/admin")
public class AdminController {

  private final Logger logger = LoggerFactory.getLogger(AdminController.class);

  @Autowired
  AppInfoService appInfoService;

  /**
   * 获取所有app列表
   *
   * @return
   */
  @RequestMapping(value = "/app", method = {RequestMethod.POST})
  @ResponseBody
  public BaseResp<String> createAppInfo() {
    String newAppId = appInfoService.createEmptyAppInfo();
    if (StringUtils.isEmpty(newAppId)) {
      return new BaseResp<String>(newAppId);
    } else {
      return new BaseResp<String>(DmpPlusConstant.RESP_FAIL, DmpPlusConstant.RESP_FAIL_MSG);
    }
  }

  /**
   * 获取所有app列表
   *
   * @return
   */
  @RequestMapping(value = "/apps", method = {RequestMethod.PUT})
  @ResponseBody
  public BaseResp<Integer> listAppInfo() {
    return new BaseResp<Integer>();
  }
}
