package com.github.yhs0092;

import org.springframework.context.annotation.ComponentScan;

import io.servicecomb.foundation.common.utils.BeanUtils;
import io.servicecomb.foundation.common.utils.Log4jUtils;

/**
 * Hello world!
 *
 */
@ComponentScan(basePackages = "com.github.yhs0092")
public class AppServer {
  public static void main(String[] args) throws Exception {
//    Log4jUtils.init();
    BeanUtils.init();
  }
}
