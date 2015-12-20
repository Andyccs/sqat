package com.sqatntu.metrics.report;


import com.sqatntu.metrics.Benchmark;
import com.sqatntu.metrics.ScoreCalculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andyccs on 25/10/15.
 */
public class MetricReport {

  private int numberOfMethods;

  private int numberOfLines;

  private int depthOfConditionNesting;

  private int lengthOfIdentifier;
  private int numberOfIdentifier;

  private int numberOfAttributes;

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

  public int getLengthOfIdentifier() {
    return lengthOfIdentifier;
  }

  public void addLengthOfIdentifier(int lengthOfIdentifier) {
    this.lengthOfIdentifier += lengthOfIdentifier;
    this.numberOfIdentifier++;
  }

  public int getAverageLengthOfIdentifier() {
    return numberOfIdentifier != 0 ? lengthOfIdentifier / numberOfIdentifier : 0;
  }

  public int getNumberOfAttributes() {
    return numberOfAttributes;
  }

  public void addNumberOfAttributes(int numberOfAttributes) {
    this.numberOfAttributes += numberOfAttributes;
  }

  public float getAnalysabilityPercentage() {
    return getAverage(
        getScore(getNumberOfLines(), Benchmark.LINE_OF_CODE),
        getScore(getDepthOfConditionNesting(), Benchmark.DEPTH_OF_CONDITION_NESTING),
        getScore(getAverageLengthOfIdentifier(), Benchmark.AVERAGE_LENGTH_OF_IDENTIFIER),
        getScore(getNumberOfAttributes(), Benchmark.NUMBER_OF_ATTRIBUTES),
        getScore(getNumberOfMethods(), Benchmark.NUMBER_OF_METHODS)
    );
  }

  public float getTestabilityPercentage() {
    return getAverage(
        getScore(getNumberOfLines(), Benchmark.LINE_OF_CODE),
        getScore(getDepthOfConditionNesting(), Benchmark.DEPTH_OF_CONDITION_NESTING)
    );
  }

  public float getOverallPercentage() {
    return getAverage(
        getAnalysabilityPercentage(),
        getTestabilityPercentage()
    );
  }

  private float getScore(int value, int benchmark) {
    return ScoreCalculator.calculateScore(value, benchmark);
  }

  private float getAverage(float... values) {
    float total = 0;

    for (float value : values) {
      total += value;
    }
    return total / values.length;
  }
}
