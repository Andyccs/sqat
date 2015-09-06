package com.sqatntu.stylechecker;

public class Logger {
  enum Level {
    ALL(0),
    VERBOSE(1),
    DEBUG(2),
    INFO(3),
    WARNING(4),
    OFF(5);

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
    formatPrint("WARNING", message);
  }

  private void formatPrint(String level, String message) {
    System.out.printf("%-8s %-10s %s\n", level, className, message);
  }

}
