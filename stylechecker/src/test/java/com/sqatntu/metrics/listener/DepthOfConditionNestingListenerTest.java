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
public class DepthOfConditionNestingListenerTest extends ListenerTest {
  @Test
  @TestCode(
      fileName = "src/test/resources/metrics/1If.java",
      detail = "A class with 1 if statement, depth of 1")
  public void OneIfStatement() {
    MetricCalculator calculator = new MetricCalculator();
    MetricReport report = calculator.calculateMetrics(testCode);
    assertEquals(1, report.getDepthOfConditionNesting());
  }

  @Test
  @TestCode(
      fileName = "src/test/resources/metrics/2If.java",
      detail = "A class with 2 if statement, depth of 2")
  public void TwoIfStatement() {
    MetricCalculator calculator = new MetricCalculator();
    MetricReport report = calculator.calculateMetrics(testCode);
    assertEquals(2, report.getDepthOfConditionNesting());
  }

  @Test
  @TestCode(
      fileName = "src/test/resources/metrics/IfElse1.java",
      detail = "A class with 1 if else statement and 1 if statement, with "
          + "the if statement on the else clause, depth of 2")
  public void IfElse1() {
    MetricCalculator calculator = new MetricCalculator();
    MetricReport report = calculator.calculateMetrics(testCode);
    assertEquals(2, report.getDepthOfConditionNesting());
  }

  @Test
  @TestCode(
      fileName = "src/test/resources/metrics/IfElse2.java",
      detail = "A more complex example, depth of 4")
  public void IfElse2() {
    MetricCalculator calculator = new MetricCalculator();
    MetricReport report = calculator.calculateMetrics(testCode);
    assertEquals(4, report.getDepthOfConditionNesting());
  }
}
