package com.sqatntu.metrics.report;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by andyccs on 25/10/15.
 */
public class MetricReport {

  List<MetricReportContent> report;

  public MetricReport() {
    report = new ArrayList<>();
  }

  public List<MetricReportContent> getReport() {
    return report;
  }

  public void addReportContents(MetricReportContent reportContents) {
    report.add(reportContents);
  }
}
