/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Andy Chong Chin Shin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software
 * is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.sqatntu.stylechecker.configuration;

import com.google.common.collect.Maps;

import com.sqatntu.stylechecker.StyleCheckerException;

import java.util.Map;
import java.util.Set;

/**
 * DefaultConfiguration store all configurations in a HashMap.
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
