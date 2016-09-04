package com.talkingdata.dmpplus.dao;

import com.talkingdata.dmpplus.dao.entity.BusinessInfo;

public interface BusinessInfoMapper {
  BusinessInfo selectByPrimaryKey(String id);
}
