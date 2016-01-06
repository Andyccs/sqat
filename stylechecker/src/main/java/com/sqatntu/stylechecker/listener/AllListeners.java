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
