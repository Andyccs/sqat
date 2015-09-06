package com.sqatntu.stylechecker.configuration;

import com.sqatntu.stylechecker.StyleCheckerException;

/**
 * Created by andyccs on 6/9/15.
 */
public interface Configuration {

  String[] getAttributeNames();

  String getAttribute(String name) throws StyleCheckerException;
}
