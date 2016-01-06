/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Andy Chong Chin Shin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

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
    String text = ctx.getChild(1).getText();
    report.addLengthOfIdentifier(text.length());
  }

  @Override
  public void enterClassDeclaration(JavaParser.ClassDeclarationContext ctx) {
    String text = ctx.getChild(1).getText();
    report.addLengthOfIdentifier(text.length());
  }

  @Override
  public void enterInterfaceDeclaration(JavaParser.InterfaceDeclarationContext ctx) {
    String text = ctx.getChild(1).getText();
    report.addLengthOfIdentifier(text.length());
  }

  @Override
  public void enterConstructorDeclaration(JavaParser.ConstructorDeclarationContext ctx) {
    String text = ctx.getStart().getText();
    report.addLengthOfIdentifier(text.length());
  }

  @Override
  public void enterInterfaceMethodDeclaration(JavaParser.InterfaceMethodDeclarationContext ctx) {
    String text = ctx.getChild(1).getText();
    report.addLengthOfIdentifier(text.length());
  }

  @Override
  public void enterConstantDeclarator(JavaParser.ConstantDeclaratorContext ctx) {
    String text = ctx.getStart().getText();
    report.addLengthOfIdentifier(text.length());
  }
}
