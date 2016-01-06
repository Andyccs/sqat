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

package com.sqatntu;

/**
 * A Simple logger with different levels
 */
public class Logger {
  public enum Level {
    ALL(0),
    VERBOSE(1),
    DEBUG(2),
    INFO(3),
    WARNING(4),
    ERROR(5),
    OFF(6);

    private int numVal;

    Level(int numVal) {
      this.numVal = numVal;
    }

    public int getNumVal() {
      return numVal;
    }
  }

  private String className;

  private Level level;

  /**
   * Create a simple logger for a class.
   * The default logging level is: WARNING.
   * @param className
   */
  public Logger(String className) {
    this.className = className;
    level = Level.WARNING;
  }

  public void setLevel(Level level) {
    this.level = level;
  }

  public void v(String message) {
    if (level.getNumVal() > Level.VERBOSE.getNumVal()) {
      return;
    }
    formatPrint("VERBOSE", message);
  }

  public void d(String message) {
    if (level.getNumVal() > Level.DEBUG.getNumVal()) {
      return;
    }
    formatPrint("DEBUG", message);
  }

  public void i(String message) {
    if (level.getNumVal() > Level.INFO.getNumVal()) {
      return;
    }
    formatPrint("INFO", message);
  }

  public void w(String message) {
    if (level.getNumVal() > Level.WARNING.getNumVal()) {
      return;
    }
    formatErrorPrint("WARNING", message);
  }

  public void e(String message) {
    if (level.getNumVal() > Level.ERROR.getNumVal()) {
      return;
    }
    formatErrorPrint("ERROR", message);
  }

  private void formatPrint(String level, String message) {
    System.out.printf("%-8s %-10s %s\n", level, className, message);
  }

  private void formatErrorPrint(String level, String message) {
    System.err.printf("%-8s %-10s %s\n", level, className, message);
  }

}
