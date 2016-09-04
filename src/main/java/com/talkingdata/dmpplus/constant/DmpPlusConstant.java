package com.talkingdata.dmpplus.constant;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class DmpPlusConstant {
  public final static int RESP_FAIL = 0;
  public final static int RESP_SUCC = 1;
  public final static String RESP_SUCC_MSG = "Success";
  public final static String RESP_FAIL_MSG = "Failed";

  public final static String APP_TAG_NEW = "new";
  public final static String APP_TAG_RECOMMEND = "recommend";

  /**
   * 程序默认字符集
   */
  public static final Charset ENCODING_UTF_8 = StandardCharsets.UTF_8;

  public final static int APP_MEDIA_VEDIO = 0;
  public final static int APP_MEDIA_IMAGE = 1;
  public final static int APP_MEDIA_MAINCUSTOM = 2;

  public final static int APP_ACCESS_AUTH_ANONYMOUS = 1;
}
