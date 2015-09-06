package com.sqatntu.stylechecker.configuration;

import com.google.common.collect.Maps;

import com.sqatntu.stylechecker.StyleCheckerException;

import java.util.Map;
import java.util.Set;

/**
 * Created by andyccs on 6/9/15.
 */
public final class DefaultConfiguration implements Configuration {

  private final Map<String, String> attributeMap = Maps.newHashMap();

  @Override
  public String[] getAttributeNames() {
    final Set<String> keySet = attributeMap.keySet();
    return keySet.toArray(new String[keySet.size()]);
  }

  @Override
  public String getAttribute(String attributeName) throws StyleCheckerException {
    if (!attributeMap.containsKey(attributeName)) {
      throw new StyleCheckerException(
          "missing key '" + attributeName + "'");
    }
    return attributeMap.get(attributeName);
  }

  public void addAttribute(String attributeName, String value) {
    final String current = attributeMap.put(attributeName, value);
    if (current == null) {
      attributeMap.put(attributeName, value);
    } else {
      attributeMap.put(attributeName, current + "," + value);
    }
  }
}
