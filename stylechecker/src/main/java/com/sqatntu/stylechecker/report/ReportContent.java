package com.sqatntu.stylechecker.report;

/**
 * Created by andyccs on 6/9/15.
 */
public class ReportContent {

  private int lineNumber;

  private int columnNumber;

  private String message;

  private String suggestion;

  public ReportContent(int lineNumber, int columnNumber, String message) {
    this.lineNumber = lineNumber;
    this.columnNumber = columnNumber;
    this.message = message;
  }

  public ReportContent(int lineNumber, int columnNumber, String message, String suggestion) {
    this.lineNumber = lineNumber;
    this.columnNumber = columnNumber;
    this.message = message;
    this.suggestion = suggestion;
  }

  public int getLineNumber() {
    return lineNumber;
  }

  public int getColumnNumber() {
    return columnNumber;
  }

  public String getMessage() {
    return message;
  }

  public String getSuggestion() {
    return suggestion;
  }
}
