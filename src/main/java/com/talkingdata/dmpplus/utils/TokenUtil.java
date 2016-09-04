package com.talkingdata.dmpplus.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TokenUtil {
  private static final Logger logger = LoggerFactory.getLogger(TokenUtil.class);
  private static final String TOKEN_SEPERATOR = "#";

  public static TokenBean decodeToken(String token) throws Exception {
    String key = AESUtil.desEncrypt(token);
    logger.debug(key);
    String[] keys = key.split(TOKEN_SEPERATOR);
    return new TokenBean(keys[0].trim(), keys[1].trim(), Long.valueOf(keys[2].trim()));
  }

  public static String encodeToken(TokenBean tokenBean) {
    StringBuffer sb = new StringBuffer();
    sb.append(tokenBean.getUsername()).append(TOKEN_SEPERATOR).append(tokenBean.getIp());
    sb.append(TOKEN_SEPERATOR).append(tokenBean.getExpiredTime());
    return AESUtil.encrypt(sb.toString());
  }
}
