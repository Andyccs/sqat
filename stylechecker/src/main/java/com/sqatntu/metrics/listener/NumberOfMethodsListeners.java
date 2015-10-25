package com.sqatntu.metrics.listener;

import com.sqatntu.metrics.report.MetricReport;
import com.sqatntu.stylechecker.api.JavaBaseListener;
import com.sqatntu.stylechecker.api.JavaParser;

/**
 * Created by andyccs on 25/10/15.
 */
public class NumberOfMethodsListeners extends JavaBaseListener {

  private MetricReport report;

  public NumberOfMethodsListeners(MetricReport report) {
    this.report = report;
  }

  @Override
  public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {

  }
}
