package com.sqatntu.metrics.listener;

import com.sqatntu.api.JavaBaseListener;
import com.sqatntu.api.JavaParser;
import com.sqatntu.metrics.report.MetricReport;

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
    int currentNumberOfMethods = report.getNumberOfMethods();
    report.setNumberOfMethods(++currentNumberOfMethods);
  }
}
