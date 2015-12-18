package com.sqatntu.metrics.injection;

import com.sqatntu.ThrowingErrorListener;
import com.sqatntu.metrics.MetricCalculator;
import com.sqatntu.metrics.report.MetricReport;
import com.sqatntu.stylechecker.StyleChecker;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module(
    injects = {
        MetricCalculator.class
    })
public class MetricCalculatorModule {
  @Provides
  MetricReport provideMetricReport() {
    return new MetricReport();
  }

  @Provides
  @Singleton
  ThrowingErrorListener provideThrowingErrorListener() {
    return new ThrowingErrorListener();
  }
}
