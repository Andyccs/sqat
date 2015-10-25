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

import com.sqatntu.ThrowingErrorListener;
import com.sqatntu.api.JavaLexer;
import com.sqatntu.api.JavaParser;
import com.sqatntu.stylechecker.configuration.Configuration;
import com.sqatntu.stylechecker.configuration.ConfigurationLoader;
import com.sqatntu.stylechecker.injection.StyleCheckerModule;
import com.sqatntu.stylechecker.listener.AllListeners;
import com.sqatntu.stylechecker.report.StyleReport;
import dagger.ObjectGraph;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

import javax.inject.Inject;

/**
 * StyleChecker provides only one method, i.e. the {@link #checkSourceCode} method.
 * The method accepts source code and style check configuration and performs style
 * checking by using Visitor pattern.
 */
public class StyleChecker {

  @Inject
  public StyleReport styleReport;

  @Inject
  ConfigurationLoader configurationLoader;

  @Inject
  ThrowingErrorListener throwingErrorListener;

  public StyleChecker() {
    ObjectGraph objectGraph = ObjectGraph.create(new StyleCheckerModule());
    objectGraph.inject(this);
  }

  @Deprecated
  public StyleReport checkFile(String filePath, String configPath) throws IOException {
    // Set up configuration loader
    Configuration configuration = configurationLoader.loadFileConfiguration(configPath);
    ANTLRFileStream stream = new ANTLRFileStream(filePath);

    return check(stream, configuration);
  }

  public StyleReport checkSourceCode(String sourceCode, String jsonConfig)
      throws StyleCheckerException {
    // Set up configuration loader
    Configuration configuration = configurationLoader.loadJsonConfiguration(jsonConfig);

    ANTLRInputStream stream = new ANTLRInputStream(sourceCode);

    try {
      return check(stream, configuration);
    } catch (ParseCancellationException e) {
      throw new StyleCheckerException(e.getMessage());
    }
  }

  private StyleReport check(CharStream stream, Configuration config) {
    JavaLexer lexer = new JavaLexer(stream);
    lexer.removeErrorListeners();
    lexer.addErrorListener(throwingErrorListener);

    CommonTokenStream tokens = new CommonTokenStream(lexer);

    JavaParser parser = new JavaParser(tokens);
    parser.removeErrorListeners();
    parser.addErrorListener(throwingErrorListener);

    JavaParser.CompilationUnitContext tree = parser.compilationUnit(); // parse 

    AllListeners allListeners = new AllListeners(config, styleReport);
    ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
    walker.walk(allListeners, tree);

    return styleReport;
  }
}
