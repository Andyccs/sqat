package com.sqatntu.stylechecker.configuration;

/**
 * Created by andyccs on 6/9/15.
 */
public class ConfigurationLoader {

  DefaultConfiguration configuration;

  public ConfigurationLoader() {
    configuration = new DefaultConfiguration("Default");
    configuration.addAttribute(
        StyleName.METHOD_NAME_FORMAT,
        StyleName.METHOD_NAME_FORMAT_CAMEL_CASE);
  }

  public Configuration loadConfiguration() {
    return configuration;
  }
}
