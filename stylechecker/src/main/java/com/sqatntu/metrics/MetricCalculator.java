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

package com.sqatntu.metrics;

import com.sqatntu.ThrowingErrorListener;
import com.sqatntu.api.JavaLexer;
import com.sqatntu.api.JavaParser;
import com.sqatntu.metrics.injection.MetricCalculatorModule;
import com.sqatntu.metrics.listener.AverageLengthOfIdentifierListener;
import com.sqatntu.metrics.listener.DepthOfConditionNestingListener;
import com.sqatntu.metrics.listener.NumberOfAttributesListener;
import com.sqatntu.metrics.listener.NumberOfLinesListener;
import com.sqatntu.metrics.listener.NumberOfMethodsListener;
import com.sqatntu.metrics.report.MetricReport;
import dagger.ObjectGraph;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import javax.inject.Inject;

/**
 * Created by andyccs on 25/10/15.
 */
public class MetricCalculator {

  @Inject
  MetricReport report;

  @Inject
  ThrowingErrorListener throwingErrorListener;

  public MetricCalculator() {
    ObjectGraph objectGraph = ObjectGraph.create(new MetricCalculatorModule());
    objectGraph.inject(this);
  }

  public MetricReport calculateMetrics(String sourceCode) {
    ANTLRInputStream stream = new ANTLRInputStream(sourceCode);

    JavaLexer lexer = new JavaLexer(stream);
    lexer.removeErrorListeners();
    lexer.addErrorListener(throwingErrorListener);

    CommonTokenStream tokens = new CommonTokenStream(lexer);

    JavaParser parser = new JavaParser(tokens);
    parser.removeErrorListeners();
    parser.addErrorListener(throwingErrorListener);

    JavaParser.CompilationUnitContext tree = parser.compilationUnit(); // parse
    ParseTreeWalker walker = new ParseTreeWalker();

    NumberOfMethodsListener numberOfMethodsListeners = new NumberOfMethodsListener(report);
    walker.walk(numberOfMethodsListeners, tree);

    NumberOfLinesListener numberOfLineListeners = new NumberOfLinesListener(report);
    walker.walk(numberOfLineListeners, tree);

    DepthOfConditionNestingListener ifDepthListener = new DepthOfConditionNestingListener(report);
    walker.walk(ifDepthListener, tree);

    AverageLengthOfIdentifierListener identifierLengthListener =
        new AverageLengthOfIdentifierListener(report);
    walker.walk(identifierLengthListener, tree);

    NumberOfAttributesListener attributesListener = new NumberOfAttributesListener(report);
    walker.walk(attributesListener, tree);

    return report;
  }
}
