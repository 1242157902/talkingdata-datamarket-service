package com.talkingdata.dmpplus.dao;

import com.talkingdata.dmpplus.dao.entity.UserInfo;

public interface UserInfoMapper {
  UserInfo selectByPrimaryKey(String id);

  UserInfo selectByUserNamePassword(UserInfo record);

  String selectIdByUserName(String username);

  String selectTokenByUserName(String username);

  int updateToken(UserInfo record);
}
