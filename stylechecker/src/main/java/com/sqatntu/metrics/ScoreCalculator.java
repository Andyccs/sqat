package com.sqatntu.metrics;

/**
 * Created by andyccs on 20/12/15.
 */
public class ScoreCalculator {
  public static float calculateScore(int value, int benchmark) {
    if (value <= benchmark) {
      return 100f;
    }
    return (((-2f / (3f * benchmark)) * value) + (5f / 3f)) * 100f;
  }
}
