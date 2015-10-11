package com.sqatntu.stylechecker.listener;

import com.sqatntu.stylechecker.api.JavaBaseListener;
import com.sqatntu.stylechecker.api.JavaParser;
import com.sqatntu.stylechecker.configuration.Configuration;
import com.sqatntu.stylechecker.report.StyleReport;

/**
 * Created by andyccs on 11/10/15.
 */
public class AllListeners extends JavaBaseListener {

  private MethodNameFormatListener methodNameFormatListener;
  private WildCardImportStatementListener wildCardImportStatementListener;

  public AllListeners(Configuration configuration, StyleReport report) {
    methodNameFormatListener = new MethodNameFormatListener(configuration, report);
    wildCardImportStatementListener = new WildCardImportStatementListener(configuration, report);
  }

  @Override
  public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
    methodNameFormatListener.enterMethodDeclaration(ctx);
  }

  @Override
  public void enterImportDeclaration(JavaParser.ImportDeclarationContext ctx) {
    wildCardImportStatementListener.enterImportDeclaration(ctx);
  }
}
