package com.talkingdata.dmpplus.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class SpringContextWrapper implements ApplicationContextAware {

  private static ApplicationContext appContext;

  /**
   * 根据beanName 获取bean实例
   *
   * @param beanName
   * @return
   */
  public static Object getBean(String beanName) {
    Object obj = null;
    if (null != appContext) {
      obj = appContext.getBean(beanName);
    }
    return obj;
  }

  /**
   * 根据bean名称和类型进行获取Bean的实例
   *
   * @param beanName
   * @param clsType
   * @return
   */
  public static <T> T getBean(String beanName, Class<T> clsType) {
    T obj = null;
    if (null != appContext) {
      obj = appContext.getBean(beanName, clsType);
    }
    return obj;
  }

  /**
   * 根据类型进行获取Bean的实例
   *
   * @param clsType
   * @return
   */
  public static <T> T getBean(Class<T> clsType) {
    T obj = null;
    if (null != appContext) {
      obj = appContext.getBean(clsType);
    }
    return obj;
  }

  /**
   * 根据类型进行获取Bean的实例
   *
   * @param clsType
   * @return
   */
  public static String getPropValue(String resource, String key) {
    Resource res = appContext.getResource("classpath:" + resource);
    try {
      InputStream is = res.getInputStream();
      BufferedReader br = new BufferedReader(new InputStreamReader(is));
      String line;
      while ((line = br.readLine()) != null) {
        if (line.startsWith(key + "=")) {
          return line.substring(key.length() + 1);
        }
      }
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "";
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    SpringContextWrapper.appContext = applicationContext;

    // for (String name : appContext.getBeanDefinitionNames()) {
    // System.out.println("SpringContext ----------" + name);
    // }
  }
}
