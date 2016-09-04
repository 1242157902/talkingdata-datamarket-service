package com.talkingdata.dmpplus.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.talkingdata.dmpplus.constant.DmpPlusConstant;
import com.talkingdata.dmpplus.controller.request.LoginReq;
import com.talkingdata.dmpplus.controller.response.BaseResp;
import com.talkingdata.dmpplus.controller.response.LoginResp;
import com.talkingdata.dmpplus.service.UserService;
import com.talkingdata.dmpplus.utils.IPv4Util;

@Controller
@RequestMapping("/")
public class UserController {

  private final Logger logger = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private UserService userService;

  /**
   * 用户登录
   *
   * @param req
   * @return
   */
  @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.OPTIONS})
  @ResponseBody
  public BaseResp<LoginResp> login(HttpServletRequest request, @RequestBody LoginReq req) {
    logger.info("=================>/login interface called!");
    try {
      // TODO: decrypt
      String username = req.getUsername();
      // String password = RSAUtils.decryptByPrivateKey(req.getPassword());
      boolean checkedUser = userService.checkUser(username, req.getPassword());
      String accessToken = userService.generateAccessToken(username, IPv4Util.getIpAddr(request));
      if (checkedUser && userService.saveAccessToken(username, accessToken)) {
        logger.info("=================>/return 1");
        return new BaseResp<LoginResp>(new LoginResp(accessToken));
      } else {
        logger.info("=================>/return 2");
        return new BaseResp<LoginResp>(DmpPlusConstant.RESP_FAIL, DmpPlusConstant.RESP_FAIL_MSG);
      }
    } catch (Exception e) {
      logger.info("=================>/return 3");
      logger.error(e.getMessage(), e);
      return new BaseResp<LoginResp>(DmpPlusConstant.RESP_FAIL, e.getMessage());
    }
  }
}
