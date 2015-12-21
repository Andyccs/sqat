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
public class NumberOfLineListenerTest extends ListenerTest {
  @Test
  @TestCode(
      fileName = "src/test/resources/metrics/2Lines.java",
      detail = "A class with 2 line of codes")
  public void TwoLineOfCode() {
    MetricCalculator calculator = new MetricCalculator();
    MetricReport report = calculator.calculateMetrics(testCode);
    assertEquals(2, report.getNumberOfLines());
  }

  @Test
  @TestCode(
      fileName = "src/test/resources/metrics/6Lines.java",
      detail = "A class with 6 line of codes")
  public void SixLineOfCode() {
    MetricCalculator calculator = new MetricCalculator();
    MetricReport report = calculator.calculateMetrics(testCode);
    assertEquals(6, report.getNumberOfLines());
  }
}
