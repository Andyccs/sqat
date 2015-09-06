/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Andy Chong Chin Shin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software
 * is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.sqatntu.stylechecker;

import com.sqatntu.stylechecker.api.JavaLexer;
import com.sqatntu.stylechecker.api.JavaParser;
import com.sqatntu.stylechecker.api.JavaParser.CompilationUnitContext;
import com.sqatntu.stylechecker.injection.Dagger;
import com.sqatntu.stylechecker.listener.MethodNameFormatListener;
import com.sqatntu.stylechecker.report.ReportContent;
import com.sqatntu.stylechecker.report.StyleReport;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

/**
 * Main class for Style Checker
 */
public class Main {

  @Inject
  public StyleReport styleReport;

  public static void main(String[] args) throws IOException {
    String testFilePath =
        "src/main/java/com/sqatntu/stylechecker/listener/MethodNameFormatListener.java";

    ANTLRFileStream stream = new ANTLRFileStream(testFilePath);
    JavaLexer lexer = new JavaLexer(stream);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    JavaParser parser = new JavaParser(tokens);
    CompilationUnitContext tree = parser.compilationUnit(); // parse 

    ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
    MethodNameFormatListener extractor = new MethodNameFormatListener();
    walker.walk(extractor, tree); // initiate walk of tree with listener

    Main main = new Main();
    Dagger.inject(main);

    List<ReportContent> contents = main.styleReport.getReportContents();

    Logger logger = new Logger(Main.class.getSimpleName());
    logger.setLevel(Logger.Level.ALL);
    logger.v("Hello World");
    for (ReportContent content : contents) {
      logger.v("Line: " + content.getLineNumber());
      logger.v("Column: " + content.getColumnNumber());
      logger.v("Message: " + content.getMessage());
      logger.v("Suggestion: " + content.getSuggestion());
    }
  }
}
