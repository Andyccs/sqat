package com.sqatntu.stylechecker;

import com.sqatntu.stylechecker.JavaLexer;
import com.sqatntu.stylechecker.JavaParser;
import com.sqatntu.stylechecker.JavaParser.CompilationUnitContext;

import com.sqatntu.stylechecker.configuration.Configuration;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import javax.inject.Inject;
import java.io.IOException;

/**
 * Main class for Style Checker
 */

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Hello World");

        ANTLRFileStream stream = new ANTLRFileStream("src/main/java/com/sqatntu/stylechecker/MethodListener.java");
        JavaLexer lexer = new JavaLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);
        CompilationUnitContext tree = parser.compilationUnit(); // parse 

        ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
        MethodListener extractor = new MethodListener();
        walker.walk(extractor, tree); // initiate walk of tree with listener
    }
}
