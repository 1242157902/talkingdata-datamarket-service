package com.talkingdata.dmpplus.controller.response;

import java.util.ArrayList;
import java.util.List;

public class AppInfoMediaResp {
  private List<String> videoUrl;
  private List<String> imgUrl;

  public AppInfoMediaResp() {
    super();
  }

  public AppInfoMediaResp(List<String> videoUrl, List<String> imgUrl) {
    super();
    this.videoUrl = videoUrl;
    this.imgUrl = imgUrl;
  }

  public List<String> getVideoUrl() {
    if (videoUrl == null) {
      videoUrl = new ArrayList<String>();
    }
    return videoUrl;
  }

  public List<String> getImgUrl() {
    if (imgUrl == null) {
      imgUrl = new ArrayList<String>();
    }
    return imgUrl;
  }

}
