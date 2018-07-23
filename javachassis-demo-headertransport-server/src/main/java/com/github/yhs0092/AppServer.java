package com.github.yhs0092;

import org.apache.servicecomb.foundation.common.utils.BeanUtils;
import org.apache.servicecomb.foundation.common.utils.Log4jUtils;

/**
 * Hello world!
 *
 */
public class AppServer {
  public static void main(String[] args) throws Exception {
    Log4jUtils.init();
    BeanUtils.init();
  }
}
