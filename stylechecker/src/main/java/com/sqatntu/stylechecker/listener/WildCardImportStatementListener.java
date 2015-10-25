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
import com.sqatntu.stylechecker.configuration.StyleName;
import com.sqatntu.stylechecker.report.StyleReport;
import com.sqatntu.stylechecker.report.StyleReportContent;

/**
 * Created by andyccs on 22/9/15.
 */
public class WildCardImportStatementListener extends JavaBaseListener {

  private Configuration configuration;
  private StyleReport report;

  public WildCardImportStatementListener(Configuration configuration, StyleReport report) {
    this.configuration = configuration;
    this.report = report;
  }

  @Override
  public void enterImportDeclaration(JavaParser.ImportDeclarationContext ctx) {
    super.enterImportDeclaration(ctx);

    try {
      if (configuration.getAttribute(StyleName.WILD_CARD_IMPORT)
          .equals(StyleName.WILD_CARD_IMPORT_OK)) {
        return;
      }
    } catch (StyleCheckerException e) {
      System.out.println(e.getMessage());
      return;
    }

    StringBuilder sb = new StringBuilder();

    // index 0 is always "import"
    for (int i = 1; i < ctx.getChildCount(); i++) {
      sb.append(ctx.getChild(i).getText());
    }

    String importStatement = sb.toString();
    String regex = ".+\\.\\*;$";

    if (!importStatement.matches(regex)) {
      return;
    }

    int line = ctx.getStart().getLine();
    int column = ctx.getStart().getCharPositionInLine()
        + ctx.getChild(0).getText().length() + 2;
    String message = "You should not use wild card import statement";
    String suggestion = "Split this statement to multiple import statements";

    StyleReportContent reportContent = new StyleReportContent(line, column, message, suggestion);
    report.addReportContents(reportContent);
  }
}
