package com.sqatntu.metrics.report;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by andyccs on 25/10/15.
 */
public class MetricReport {

  private int numberOfMethods;

  private int numberOfLines;

  private int depthOfConditionNesting;

  public int getNumberOfMethods() {
    return numberOfMethods;
  }

  public void setNumberOfMethods(int numberOfMethods) {
    this.numberOfMethods = numberOfMethods;
  }

  public int getNumberOfLines() {
    return numberOfLines;
  }

  public void setNumberOfLines(int numberOfLines) {
    this.numberOfLines = numberOfLines;
  }

  public int getDepthOfConditionNesting() {
    return depthOfConditionNesting;
  }

  public void setDepthOfConditionNesting(int depthOfConditionNesting) {
    this.depthOfConditionNesting = depthOfConditionNesting;
  }
}
