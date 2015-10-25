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
}
