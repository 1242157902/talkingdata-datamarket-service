package com.talkingdata.dmpplus.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.alibaba.fastjson.JSONObject;
import com.talkingdata.dmpplus.constant.DmpPlusConstant;
import com.talkingdata.dmpplus.controller.response.BaseResp;
import com.talkingdata.dmpplus.controller.response.LoginResp;
import com.talkingdata.dmpplus.service.UserService;
import com.talkingdata.dmpplus.utils.IPv4Util;
import com.talkingdata.dmpplus.utils.SpringContextWrapper;

/**
 * 继承OncePerRequestFilter保证一次请求只过滤一次(以兼容不同的servlet container)
 *
 */
public class AuthFilter extends OncePerRequestFilter {
  private final Logger logger = LoggerFactory.getLogger(AuthFilter.class);

  private final PathMatcher matcher = new AntPathMatcher();
  private final List<String> excludes = new ArrayList<>();

  private UserService userService;

  @Override
  protected void initFilterBean() throws ServletException {
    FilterConfig config = getFilterConfig();
    String paths = config.getInitParameter("exclude");
    if (!StringUtils.isEmpty(paths)) {
      excludes.addAll(Arrays.asList(paths.split(",")));
    }
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    logger.debug(request.getRequestURI());
    if (userService == null) {
      userService = (UserService) SpringContextWrapper.getBean("userServiceImpl");
    }

    String url = request.getRequestURI();
    for (String match : excludes) {
      if (matcher.match(match, url)) {
        logger.debug("=====>should not check auth,do other filter and return," + match + " " + url);
        filterChain.doFilter(request, response);
        return;
      }
    }
    logger.debug("=====>will do auth filter");

    String auth = request.getHeader("Authorization");
    boolean checked = false;
    if ((auth != null) && (auth.length() > 6)) {
      auth = auth.substring(6, auth.length());
      // String decodedAuth = new String(Base64.decodeBase64(auth));
      logger.debug(auth);
      // logger.debug(decodedAuth);
      checked = userService.checkUserToken(auth, IPv4Util.getIpAddr(request));
    }
    if (!checked) {
      response.setContentType("application/json");
      response.setCharacterEncoding(DmpPlusConstant.ENCODING_UTF_8.name());
      BaseResp<LoginResp> resp = new BaseResp<LoginResp>(DmpPlusConstant.RESP_FAIL, DmpPlusConstant.RESP_FAIL_MSG);
      response.getWriter().write(JSONObject.toJSON(resp).toString());
    } else {
      filterChain.doFilter(request, response);
    }
  }
}
