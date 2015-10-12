package com.sqatntu.stylechecker.listener;

import static org.junit.Assert.assertEquals;

import com.sqatntu.stylechecker.ListenerTest;
import com.sqatntu.stylechecker.StyleChecker;
import com.sqatntu.stylechecker.StyleCheckerException;
import com.sqatntu.stylechecker.TestCode;
import com.sqatntu.stylechecker.TestConfig;
import com.sqatntu.stylechecker.report.StyleReport;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by andyccs on 11/10/15.
 */
public class BraceStyleListenerTest extends ListenerTest {

  @Test
  @TestCode(
      detail = "krStyleCode",
      fileName = "src/test/resources/BraceKRStyle.java")
  @TestConfig(
      detail = "krStyleConfig",
      fileName = "src/test/resources/BraceKRStyle.json")
  public void braceStyle1() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(0, report.getReportContents().size());
  }

  @Test
  @TestCode(
      detail = "krStyleCode",
      fileName = "src/test/resources/BraceKRStyle.java")
  @TestConfig(
      detail = "nonKrStyleConfig",
      fileName = "src/test/resources/BraceNonKRStyle.json")
  public void braceStyle2() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(4, report.getReportContents().size());
  }

  @Test
  @TestCode(
      detail = "krStyleCode",
      fileName = "src/test/resources/BraceKRStyle.java")
  @TestConfig(
      detail = "ignoreConfig",
      fileName = "src/test/resources/ignoreAll.json")
  public void braceStyle3() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(0, report.getReportContents().size());
  }

  @Test
  @TestCode(
      detail = "NonKrStyleCode",
      fileName = "src/test/resources/BraceNonKRStyle.java")
  @TestConfig(
      detail = "krStyleConfig",
      fileName = "src/test/resources/BraceKRStyle.json")
  public void braceStyle4() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(4, report.getReportContents().size());
  }

  @Test
  @TestCode(
      detail = "NonKrStyleCode",
      fileName = "src/test/resources/BraceNonKRStyle.java")
  @TestConfig(
      detail = "nonKrStyleConfig",
      fileName = "src/test/resources/BraceNonKRStyle.json")
  public void braceStyle5() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(0, report.getReportContents().size());
  }

  @Test
  @TestCode(
      detail = "NonKrStyleCode",
      fileName = "src/test/resources/BraceNonKRStyle.java")
  @TestConfig(
      detail = "ignoreConfig",
      fileName = "src/test/resources/ignoreAll.json")
  public void braceStyle6() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(0, report.getReportContents().size());
  }

  @Test
  @TestCode(
      detail = "krStyleCodeInterface",
      fileName = "src/test/resources/BraceKRStyleInterface.java")
  @TestConfig(
      detail = "krStyleConfig",
      fileName = "src/test/resources/BraceKRStyle.json")
  public void braceStyle7() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(0, report.getReportContents().size());
  }

  @Test
  @TestCode(
      detail = "krStyleCodeInterface",
      fileName = "src/test/resources/BraceKRStyleInterface.java")
  @TestConfig(
      detail = "nonKrStyleConfig",
      fileName = "src/test/resources/BraceNonKRStyle.json")
  public void braceStyle8() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(1, report.getReportContents().size());
  }

  @Test
  @TestCode(
      detail = "krStyleCodeInterface",
      fileName = "src/test/resources/BraceKRStyleInterface.java")
  @TestConfig(
      detail = "ignoreConfig",
      fileName = "src/test/resources/ignoreAll.json")
  public void braceStyle9() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(0, report.getReportContents().size());
  }

  @Test
  @TestCode(
      detail = "nonKrStyleCodeInterface",
      fileName = "src/test/resources/BraceNonKRStyleInterface.java")
  @TestConfig(
      detail = "krStyleConfig",
      fileName = "src/test/resources/BraceKRStyle.json")
  public void braceStyle10() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(1, report.getReportContents().size());
  }

  @Test
  @TestCode(
      detail = "nonKrStyleCodeInterface",
      fileName = "src/test/resources/BraceNonKRStyleInterface.java")
  @TestConfig(
      detail = "nonKrStyleConfig",
      fileName = "src/test/resources/BraceNonKRStyle.json")
  public void braceStyle11() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(0, report.getReportContents().size());
  }

  @Test
  @TestCode(
      detail = "nonKrStyleCodeInterface",
      fileName = "src/test/resources/BraceNonKRStyleInterface.java")
  @TestConfig(
      detail = "ignoreConfig",
      fileName = "src/test/resources/ignoreAll.json")
  public void braceStyle12() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(0, report.getReportContents().size());
  }
}