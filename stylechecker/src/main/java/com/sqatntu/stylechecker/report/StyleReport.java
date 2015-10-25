package com.sqatntu.stylechecker.report;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andyccs on 6/9/15.
 */
public class StyleReport {

  List<StyleReportContent> reportContents;

  public StyleReport() {
    reportContents = new ArrayList<>();
  }

  public List<StyleReportContent> getReportContents() {
    return ImmutableList.<StyleReportContent>builder().addAll(reportContents).build();
  }

  public void addReportContents(StyleReportContent reportContents) {
    this.reportContents.add(reportContents);
  }
}
