package com.sqatntu.stylechecker.listener;

import com.sqatntu.stylechecker.StyleCheckerException;
import com.sqatntu.stylechecker.api.JavaBaseListener;
import com.sqatntu.stylechecker.api.JavaParser;
import com.sqatntu.stylechecker.configuration.Configuration;
import com.sqatntu.stylechecker.configuration.StyleName;
import com.sqatntu.stylechecker.report.StyleReport;
import com.sqatntu.stylechecker.report.StyleReportContent;

/**
 * Created by andyccs on 11/10/15.
 */
public class BraceStyleListener extends JavaBaseListener {

  private Configuration configuration;
  private StyleReport report;

  public BraceStyleListener(Configuration configuration, StyleReport report) {
    this.configuration = configuration;
    this.report = report;
  }

  @Override
  public void enterBlock(JavaParser.BlockContext ctx) {
    String attribute = null;
    try {
      attribute = configuration.getAttribute(StyleName.BRACE_STYLE);
    } catch (StyleCheckerException e) {
      // This means that no configuration for method name format is set,
      // so we don't do any check.
      System.out.println(e.getMessage());
      return;
    }
    if (attribute.equals(StyleName.IGNORE_STYLE)) {
      return;
    }

    int column = ctx.getStart().getCharPositionInLine();
    String message = "Inconsistent brace style";

    int line = ctx.getStart().getLine();
    int parentLine = ctx.getParent().getParent().getStart().getLine();

    if (attribute.equals(StyleName.BRACE_STYLE_KR) && line != parentLine) {
      String suggestion = "You should move this braces to previous line";
      StyleReportContent reportContent = new StyleReportContent(line, column, message, suggestion);
      report.addReportContents(reportContent);
    } else if (attribute.equals(StyleName.BRACE_STYLE_NON_KR) && line == parentLine) {
      String suggestion = "You should move this braces to next line";
      StyleReportContent reportContent = new StyleReportContent(line, column, message, suggestion);
      report.addReportContents(reportContent);
    }
  }
}
