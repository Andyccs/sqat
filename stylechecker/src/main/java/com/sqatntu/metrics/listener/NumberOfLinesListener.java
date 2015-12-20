package com.sqatntu.metrics.listener;

import com.sqatntu.api.JavaBaseListener;
import com.sqatntu.api.JavaParser;
import com.sqatntu.metrics.report.MetricReport;

/**
 * Created by andyccs on 18/12/15.
 */
public class NumberOfLinesListener extends JavaBaseListener {

  private MetricReport report;

  public NumberOfLinesListener(MetricReport report) {
    this.report = report;
  }

  @Override
  public void exitClassBody(JavaParser.ClassBodyContext ctx) {
    report.setNumberOfLines(ctx.getStop().getLine());
  }
}
