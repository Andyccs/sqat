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
