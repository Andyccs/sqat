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
import com.sqatntu.stylechecker.configuration.Configuration;
import com.sqatntu.stylechecker.configuration.ConfigurationLoader;
import com.sqatntu.stylechecker.injection.Dagger;
import com.sqatntu.stylechecker.listener.MethodNameFormatListener;
import com.sqatntu.stylechecker.report.StyleReport;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

import javax.inject.Inject;

/**
 * Created by andyccs on 6/9/15.
 */
public class StyleChecker {

  @Inject
  public StyleReport styleReport;

  @Inject
  ConfigurationLoader configurationLoader;

  public StyleChecker() {
    Dagger.inject(this);
  }

  public StyleReport check(String filePath, String configPath) throws IOException {
    // Set up configuration loader
    Configuration configuration = configurationLoader.loadConfiguration(configPath);

    ANTLRFileStream stream = new ANTLRFileStream(filePath);
    JavaLexer lexer = new JavaLexer(stream);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    JavaParser parser = new JavaParser(tokens);
    JavaParser.CompilationUnitContext tree = parser.compilationUnit(); // parse 

    ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
    MethodNameFormatListener extractor = new MethodNameFormatListener(configuration, styleReport);
    walker.walk(extractor, tree); // initiate walk of tree with listener

    return styleReport;
  }
}
