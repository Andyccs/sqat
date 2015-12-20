package com.sqatntu.metrics.listener;

import com.sqatntu.api.JavaBaseListener;
import com.sqatntu.api.JavaParser;
import com.sqatntu.metrics.report.MetricReport;

import java.util.List;

/**
 * Created by andyccs on 20/12/15.
 */
public class NumberOfAttributesListener extends JavaBaseListener{

  private MetricReport report;

  public NumberOfAttributesListener(MetricReport report) {
    this.report = report;
  }

  @Override
  public void enterFieldDeclaration(JavaParser.FieldDeclarationContext ctx) {
    List<JavaParser.VariableDeclaratorContext> variableDeclaratorContexts = ctx
        .getRuleContext(JavaParser.VariableDeclaratorsContext.class, 0)
        .getRuleContexts(JavaParser.VariableDeclaratorContext.class);

    report.addNumberOfAttributes(variableDeclaratorContexts.size());
  }
}
