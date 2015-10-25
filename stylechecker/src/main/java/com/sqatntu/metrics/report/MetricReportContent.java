package com.sqatntu.metrics.report;

/**
 * Created by andyccs on 25/10/15.
 */
public class MetricReportContent {

  private String metricName;

  private float value;

  public MetricReportContent(String metricName, float value) {
    this.metricName = metricName;
    this.value = value;
  }

  public String getMetricName() {
    return metricName;
  }

  public void setMetricName(String metricName) {
    this.metricName = metricName;
  }

  public float getValue() {
    return value;
  }

  public void setValue(float value) {
    this.value = value;
  }
}
