package com.sqatntu.metrics.listener;

import com.sqatntu.api.JavaBaseListener;
import com.sqatntu.api.JavaParser;
import com.sqatntu.metrics.report.MetricReport;

/**
 * Created by andyccs on 18/12/15.
 */
public class AverageLengthOfIdentifierListener extends JavaBaseListener {

  private MetricReport report;

  public AverageLengthOfIdentifierListener(MetricReport report) {
    this.report = report;
  }

  @Override
  public void enterVariableDeclaratorId(JavaParser.VariableDeclaratorIdContext ctx) {
    String text = ctx.getStart().getText();
    report.addLengthOfIdentifier(text.length());
  }

  @Override
  public void enterEnumDeclaration(JavaParser.EnumDeclarationContext ctx) {
    String text = ctx.getChild(1).getText();
    report.addLengthOfIdentifier(text.length());
  }

  @Override
  public void enterEnumConstant(JavaParser.EnumConstantContext ctx) {
    String text = ctx.getStart().getText();
    report.addLengthOfIdentifier(text.length());
  }

  @Override
  public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
    String text = ctx.getStart().getText();
    System.out.println(text);
  }

  @Override
  public void enterClassDeclaration(JavaParser.ClassDeclarationContext ctx) {
    String text = ctx.getStart().getText();
    System.out.println(text);
  }

  @Override
  public void enterInterfaceDeclaration(JavaParser.InterfaceDeclarationContext ctx) {
    String text = ctx.getStart().getText();
    System.out.println(text);
  }
}
