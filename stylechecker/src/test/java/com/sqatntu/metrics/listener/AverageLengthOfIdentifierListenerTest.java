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
