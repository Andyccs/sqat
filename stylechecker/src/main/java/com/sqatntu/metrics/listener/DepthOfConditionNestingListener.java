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
    if (!text.equals("if")
        && !text.equals("while")
        && !text.equals("for")
        && !text.equals("do")) {
      return;
    }

    int depth = 1;
    ParserRuleContext tempContext = ctx.getParent();
    while (!(tempContext instanceof JavaParser.MethodDeclarationContext)) {
      if (tempContext instanceof JavaParser.StatementContext) {
        text = tempContext.getStart().getText();
        if (text.equals("if")
            || text.equals("while")
            || text.equals("for")
            || text.equals("do")) {
          depth++;
        }
      }
      tempContext = tempContext.getParent();
    }
    report.setDepthOfConditionNesting(depth);
  }
}
