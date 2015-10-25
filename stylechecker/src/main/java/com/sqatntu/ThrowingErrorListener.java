package com.sqatntu;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

/**
 * When {@code JavaLexer} or {@code JavaParser} failed to parse source codes, this
 * listener will respond by throwing {@code ParseCancellationException}
 */
public class ThrowingErrorListener extends BaseErrorListener {

  @Override
  public void syntaxError(
      Recognizer<?, ?> recognizer,
      Object offendingSymbol,
      int line,
      int charPositionInLine,
      String message,
      RecognitionException error)
      throws ParseCancellationException {
    throw new ParseCancellationException("line " + line + ":" + charPositionInLine + " " + message);
  }
}