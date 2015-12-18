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
}
