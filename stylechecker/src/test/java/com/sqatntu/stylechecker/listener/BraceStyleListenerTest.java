package com.sqatntu.stylechecker.listener;

import com.sqatntu.stylechecker.ListenerTest;
import com.sqatntu.stylechecker.StyleChecker;
import com.sqatntu.stylechecker.StyleCheckerException;
import com.sqatntu.stylechecker.TestCode;
import com.sqatntu.stylechecker.TestConfig;
import com.sqatntu.stylechecker.report.StyleReport;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by andyccs on 11/10/15.
 */
public class BraceStyleListenerTest extends ListenerTest {

  @Test
  @TestCode(detail = "krStyleCode", fileName = "src/test/resources/BraceKRStyle.java")
  @TestConfig(detail = "krStyleConfig", fileName = "src/test/resources/BraceKRStyle.json")
  public void braceStyle1() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(0, report.getReportContents().size());
  }
}
