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
