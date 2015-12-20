package com.sqatntu.metrics;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created by andyccs on 20/12/15.
 */
public class ScoreCalculatorTest {

  @Test
  public void test1() {
    assertEquals(97.33f, ScoreCalculator.calculateScore(208, 200), 0.01f);
  }
}
