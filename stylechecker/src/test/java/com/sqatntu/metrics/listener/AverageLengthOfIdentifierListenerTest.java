/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Andy Chong Chin Shin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.sqatntu.metrics.listener;

import static org.junit.Assert.assertEquals;

import com.sqatntu.metrics.MetricCalculator;
import com.sqatntu.metrics.report.MetricReport;
import com.sqatntu.testutil.ListenerTest;
import com.sqatntu.testutil.TestCode;
import org.junit.Test;

/**
 * Created by andyccs on 18/12/15.
 */
public class AverageLengthOfIdentifierListenerTest extends ListenerTest {
  @Test
  @TestCode(
      fileName = "src/test/resources/metrics/IdentifierVariable.java",
      detail = "two private variables")
  public void twoIdentifier() {
    MetricCalculator calculator = new MetricCalculator();
    MetricReport report = calculator.calculateMetrics(testCode);
    assertEquals(7, report.getAverageLengthOfIdentifier());
  }

  @Test
  @TestCode(
      fileName = "src/test/resources/metrics/IdentifierEnum.java",
      detail = "an enum class with two enum constans")
  public void enumIdentifier() {
    MetricCalculator calculator = new MetricCalculator();
    MetricReport report = calculator.calculateMetrics(testCode);
    assertEquals(4, report.getAverageLengthOfIdentifier());
  }

  @Test
  @TestCode(
      fileName = "src/test/resources/metrics/IdentifierMethod.java",
      detail = "an class with two methods")
  public void methodIdentifier() {
    MetricCalculator calculator = new MetricCalculator();
    MetricReport report = calculator.calculateMetrics(testCode);
    assertEquals(4, report.getAverageLengthOfIdentifier());
  }

  @Test
  @TestCode(
      fileName = "src/test/resources/metrics/IdentifierInterface.java",
      detail = "an interface with one method and one constant")
  public void interfaceIdentifier() {
    MetricCalculator calculator = new MetricCalculator();
    MetricReport report = calculator.calculateMetrics(testCode);
    assertEquals(11, report.getAverageLengthOfIdentifier());
  }

  @Test
  @TestCode(
      fileName = "src/test/resources/metrics/IdentifierConstructor.java",
      detail = "an interface with no method")
  public void constructorIdentifier() {
    MetricCalculator calculator = new MetricCalculator();
    MetricReport report = calculator.calculateMetrics(testCode);
    assertEquals(4, report.getAverageLengthOfIdentifier());
  }
}
