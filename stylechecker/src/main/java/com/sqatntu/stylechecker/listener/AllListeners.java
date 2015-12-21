package com.sqatntu.stylechecker.listener;

import com.sqatntu.api.JavaBaseListener;
import com.sqatntu.api.JavaParser;
import com.sqatntu.stylechecker.configuration.Configuration;
import com.sqatntu.stylechecker.report.StyleReport;

/**
 * Aggregate all {@link JavaBaseListener} so that we only need
 * {@link org.antlr.v4.runtime.tree.ParseTreeWalker}
 * to walk the Parse Tree once.
 */
public class AllListeners extends JavaBaseListener {

  private MethodNameFormatListener methodNameFormatListener;
  private WildCardImportStatementListener wildCardImportStatementListener;
  private BraceStyleListener braceStyleListener;

  public AllListeners(Configuration configuration, StyleReport report) {
    methodNameFormatListener = new MethodNameFormatListener(configuration, report);
    wildCardImportStatementListener = new WildCardImportStatementListener(configuration, report);
    braceStyleListener = new BraceStyleListener(configuration, report);
  }

  @Override
  public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
    methodNameFormatListener.enterMethodDeclaration(ctx);
  }

  @Override
  public void enterImportDeclaration(JavaParser.ImportDeclarationContext ctx) {
    wildCardImportStatementListener.enterImportDeclaration(ctx);
  }

  @Override
  public void enterBlock(com.sqatntu.api.JavaParser.BlockContext ctx) {
    braceStyleListener.enterBlock(ctx);
  }

  @Override
  public void enterClassBody(JavaParser.ClassBodyContext ctx) {
    braceStyleListener.enterClassBody(ctx);
  }

  @Override
  public void enterInterfaceBody(JavaParser.InterfaceBodyContext ctx) {
    braceStyleListener.enterInterfaceBody(ctx);
  }

  @Override
  public void enterStatement(JavaParser.StatementContext ctx) {
    braceStyleListener.enterStatement(ctx);
  }

  @Override
  public void enterCatchClause(JavaParser.CatchClauseContext ctx) {
    braceStyleListener.enterCatchClause(ctx);
  }

  @Override
  public void enterFinallyBlock(JavaParser.FinallyBlockContext ctx) {
    braceStyleListener.enterFinallyBlock(ctx);
  }
}
