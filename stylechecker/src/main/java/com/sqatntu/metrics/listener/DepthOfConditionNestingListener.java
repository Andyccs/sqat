package com.sqatntu.metrics.listener;

import com.sqatntu.api.JavaBaseListener;
import com.sqatntu.api.JavaParser;
import com.sqatntu.metrics.report.MetricReport;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Created by andyccs on 18/12/15.
 */
public class DepthOfConditionNestingListener extends JavaBaseListener {

  private MetricReport report;

  public DepthOfConditionNestingListener(MetricReport report) {
    this.report = report;
  }

  @Override
  public void enterStatement(JavaParser.StatementContext ctx) {
    ctx.getChildCount();
    String text = ctx.getStart().getText();
    if (!text.startsWith("if")) {
      return;
    }

    int depth = 1;
    ParserRuleContext tempContext = ctx.getParent();
    while (!(tempContext instanceof JavaParser.MethodDeclarationContext)) {
      if (tempContext instanceof JavaParser.StatementContext) {
        if (tempContext.getStart().getText().equals("if")) {
          depth++;
        }
      }
      tempContext = tempContext.getParent();
    }
    report.setDepthOfConditionNesting(depth);
  }
}
