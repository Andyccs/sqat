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

package com.sqatntu.stylechecker.listener;

import com.sqatntu.stylechecker.StyleCheckerException;
import com.sqatntu.stylechecker.api.JavaBaseListener;
import com.sqatntu.stylechecker.api.JavaParser;
import com.sqatntu.stylechecker.configuration.Configuration;
import com.sqatntu.stylechecker.configuration.ConfigurationLoader;
import com.sqatntu.stylechecker.configuration.StyleName;
import com.sqatntu.stylechecker.injection.Dagger;
import com.sqatntu.stylechecker.report.ReportContent;
import com.sqatntu.stylechecker.report.StyleReport;

import javax.inject.Inject;

/**
 * Created by andyccs on 6/9/15.
 */
public class MethodNameFormatListener extends JavaBaseListener {

  private Configuration configuration;
  private StyleReport report;

  public MethodNameFormatListener(Configuration configuration, StyleReport report) {
    this.configuration = configuration;
    this.report = report;
  }

  @Override
  public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
    String regex = "";
    String methodNameFormatValue = StyleName.IGNORE_STYLE;

    // Determine regular expression by using configuration
    try {
      if (configuration
          .getAttribute(StyleName.METHOD_NAME_FORMAT)
          .equals(StyleName.METHOD_NAME_FORMAT_CAMEL_CASE)) {
        regex = "^([a-z])([a-zA-Z0-9])*";
        methodNameFormatValue = StyleName.METHOD_NAME_FORMAT_CAMEL_CASE;
      }
    } catch (StyleCheckerException e) {
      // This means that no configuration for method name format is set,
      // so we don't do any check.
      System.out.println(e.getMessage());
      return;
    }

    // Do matching and add new report
    String methodName = ctx.getChild(1).getText();

    // If there is no problem with the method name
    if (methodName.matches(regex)) {
      return;
    }

    String message;
    String suggestion;

    switch (methodNameFormatValue) {
      case StyleName.METHOD_NAME_FORMAT_CAMEL_CASE:
        message = "You should use camel case for method name";
        suggestion = "Change method name to " + toCamelCase(methodName);
        break;
      default:
        // This should never happens
        message = "";
        suggestion = "";
        break;
    }

    int line = ctx.getStart().getLine();
    int column = ctx.getStart().getCharPositionInLine() + ctx.getChild(0).getText().length() + 2;

    ReportContent reportContent = new ReportContent(line, column, message, suggestion);
    report.addReportContents(reportContent);
  }

  private String toCamelCase(String string) {
    return string.substring(0, 1).toLowerCase() + string.substring(1);
  }
}
