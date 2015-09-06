package com.sqatntu.stylechecker.report;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andyccs on 6/9/15.
 */
public class StyleReport {

    List<ReportContent> reportContents;

    public StyleReport() {
        reportContents = new ArrayList<>();
    }

    public List<ReportContent> getReportContents() {
        return ImmutableList.<ReportContent>builder().addAll(reportContents).build();
    }

    public void addReportContents(ReportContent reportContents) {
        this.reportContents.add(reportContents);
    }
}
