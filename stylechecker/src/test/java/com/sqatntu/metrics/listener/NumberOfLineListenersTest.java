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
public class NumberOfLineListenersTest extends ListenerTest {
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
