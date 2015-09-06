package com.sqatntu.stylechecker;

public class StyleCheckerException extends Exception {
  /**
   * For Serialisation that will never happen.
   */
  private static final long serialVersionUID = -3517342299748221108L;

  /**
   * Creates a new {@code CheckstyleException} instance.
   *
   * @param message a {@code String} value
   */
  public StyleCheckerException(String message) {
    super(message);
  }

  /**
   * Creates a new {@code CheckstyleException} instance
   * that was caused by another exception.
   *
   * @param message a message that explains this exception
   * @param cause   the Exception that is wrapped by this exception
   */
  public StyleCheckerException(String message, Throwable cause) {
    super(message, cause);
  }
}
