package com.talkingdata.dmpplus.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.talkingdata.dmpplus.dao.UserInfoMapper;
import com.talkingdata.dmpplus.dao.entity.UserInfo;
import com.talkingdata.dmpplus.service.UserService;
import com.talkingdata.dmpplus.utils.TokenBean;
import com.talkingdata.dmpplus.utils.TokenUtil;

@Service
public class UserServiceImpl implements UserService {
  private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

  @Autowired
  private UserInfoMapper userInfoMapper;

  @Value("${td.dmpplus.token.millexpire}")
  private long millExpireTime;

  @Override
  public boolean checkUser(String username, String password) {
    UserInfo user = new UserInfo();
    user.setAccount(username);
    user.setPassword(password);
    UserInfo userInfo = userInfoMapper.selectByUserNamePassword(user);
    return userInfo != null;
  }

  @Override
  public boolean checkUserToken(String accessToken, String ip) {
    try {
      TokenBean tokenBean = TokenUtil.decodeToken(accessToken);
      if (tokenBean.getExpiredTime() > System.currentTimeMillis() && tokenBean.getIp().equals(ip)) {
        String savedToken = userInfoMapper.selectTokenByUserName(tokenBean.getUsername());
        if (accessToken.equals(savedToken)) {
          return true;
        }
      }
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    }
    return false;
  }

  @Override
  public String generateAccessToken(String username, String ip) {
    long time = System.currentTimeMillis() + millExpireTime;
    return TokenUtil.encodeToken(new TokenBean(username, ip, time));
  }

  @Override
  public boolean saveAccessToken(String username, String accessToken) {
    UserInfo userInfo = new UserInfo();
    userInfo.setAccount(username);
    userInfo.setAccessToken(accessToken);
    int result = userInfoMapper.updateToken(userInfo);
    return result == 1;
  }
}
