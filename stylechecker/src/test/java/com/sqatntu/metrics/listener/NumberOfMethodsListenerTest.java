package com.sqatntu.metrics.listener;

import static org.junit.Assert.assertEquals;

import com.sqatntu.metrics.MetricCalculator;
import com.sqatntu.metrics.report.MetricReport;
import com.sqatntu.testutil.ListenerTest;
import com.sqatntu.testutil.TestCode;
import org.junit.Test;

/**
 * Created by andyccs on 25/10/15.
 */
public class NumberOfMethodsListenerTest extends ListenerTest {
  @Test
  @TestCode(
      fileName = "src/test/resources/metrics/NoMethod.java",
      detail = "A class without method and constructor")
  public void noMethod() {
    MetricCalculator calculator = new MetricCalculator();
    MetricReport report = calculator.calculateMetrics(testCode);
    assertEquals(0, report.getNumberOfMethods());
  }

  @Test
  @TestCode(
      fileName = "src/test/resources/metrics/OneMethod.java",
      detail = "A class with a method")
  public void oneMethod() {
    MetricCalculator calculator = new MetricCalculator();
    MetricReport report = calculator.calculateMetrics(testCode);
    assertEquals(1, report.getNumberOfMethods());
  }
}
