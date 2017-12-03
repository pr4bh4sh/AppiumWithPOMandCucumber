package com.assignment.appium.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


public class Log {

  static Logger Log = Logger.getLogger(com.assignment.appium.logger.Log.class.getName());

  /**
   * Info message
   *
   * @param message Ex: "Clicked on Login Button"
   */
  public static void INFO(String message) {
    DOMConfigurator.configure("log4j.xml");

    Log.info(message);
  }

  /**
   * Error message
   *
   * @param message - "element is not visible"
   */
  public static void ERROR(String message) {
    DOMConfigurator.configure("log4j.xml");
    Log.error(message);
  }

}
