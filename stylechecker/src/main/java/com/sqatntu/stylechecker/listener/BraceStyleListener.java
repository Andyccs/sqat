package com.sqatntu.stylechecker.listener;

import com.sqatntu.Logger;
import com.sqatntu.api.JavaBaseListener;
import com.sqatntu.api.JavaParser;
import com.sqatntu.stylechecker.StyleCheckerException;
import com.sqatntu.stylechecker.configuration.Configuration;
import com.sqatntu.stylechecker.configuration.StyleName;
import com.sqatntu.stylechecker.report.StyleReport;
import com.sqatntu.stylechecker.report.StyleReportContent;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;

/**
 * Check brace style of source codes.
 * Three brace styles are define in {@link StyleName}:
 * 1. {@link StyleName#BRACE_STYLE_KR}
 * 2. {@link StyleName#BRACE_STYLE_NON_KR}
 * 3. {@link StyleName#IGNORE_STYLE}
 *
 * @see StyleName#BRACE_STYLE
 */
class BraceStyleListener extends JavaBaseListener {

  private static Logger LOG = new Logger(BraceStyleListener.class.getSimpleName());

  private Configuration configuration;
  private StyleReport report;

  public BraceStyleListener(Configuration configuration, StyleReport report) {
    this.configuration = configuration;
    this.report = report;
  }

  @Override
  public void enterStatement(JavaParser.StatementContext ctx) {
    if (!ctx.getStart().getText().equals("switch")) {
      return;
    }

    int parentLine =
        ctx.getRuleContext(JavaParser.ParExpressionContext.class, 0).getStart().getLine();
    int line =
        ctx.getRuleContext(JavaParser.SwitchStatementBlockContext.class, 0).getStart().getLine();
    detectBraceStyle(ctx, parentLine, line);
  }

  @Override
  public void enterBlock(JavaParser.BlockContext ctx) {
    if (ctx.getParent() instanceof JavaParser.CatchClauseContext
        || ctx.getParent() instanceof JavaParser.FinallyBlockContext) {
      return;
    }

    int parentLine = ctx.getParent().getParent().getStart().getLine();
    int line = ctx.getStart().getLine();
    detectBraceStyle(ctx, parentLine, line);
  }

  @Override
  public void enterCatchClause(JavaParser.CatchClauseContext ctx) {
    int parentLine = ctx.getStart().getLine();
    int line = ctx.getRuleContext(JavaParser.BlockContext.class, 0).getStart().getLine();
    detectBraceStyle(ctx, parentLine, line);
  }

  @Override
  public void enterFinallyBlock(JavaParser.FinallyBlockContext ctx) {
    int parentLine = ctx.getStart().getLine();
    int line = ctx.getRuleContext(JavaParser.BlockContext.class, 0).getStart().getLine();
    detectBraceStyle(ctx, parentLine, line);
  }

  @Override
  public void enterClassBody(JavaParser.ClassBodyContext ctx) {
    // TODO: this is not the best way.
    // If the 'extend' and 'implement' keywords happen to be on the next
    // line, then the detection will fail
    int parentLine = ctx.getParent().getStart().getLine();
    int line = ctx.getStart().getLine();
    detectBraceStyle(ctx, parentLine, line);
  }

  @Override
  public void enterInterfaceBody(JavaParser.InterfaceBodyContext ctx) {
    // TODO: this is not the best way.
    // If the 'extend' keyword happen to be on the next
    // line, then the detection will fail
    int parentLine = ctx.getParent().getStart().getLine();
    int line = ctx.getStart().getLine();
    detectBraceStyle(ctx, parentLine, line);
  }

  private void detectBraceStyle(ParserRuleContext ctx, final int parentLine, final int line) {
    String attribute = null;
    try {
      attribute = configuration.getAttribute(StyleName.BRACE_STYLE);
    } catch (StyleCheckerException e) {
      // This means that no configuration for method name format is set,
      // so we don't do any check.
      LOG.w(e.getMessage());
      return;
    }
    if (attribute.equals(StyleName.IGNORE_STYLE)) {
      return;
    }

    final int column = ctx.getStart().getCharPositionInLine();
    final String message = "Inconsistent brace style";

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
