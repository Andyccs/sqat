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
