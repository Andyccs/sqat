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

package com.sqatntu.stylechecker.listener;

import static org.junit.Assert.assertEquals;

import com.sqatntu.stylechecker.StyleChecker;
import com.sqatntu.stylechecker.StyleCheckerException;
import com.sqatntu.stylechecker.report.StyleReport;
import com.sqatntu.testutil.ListenerTest;
import com.sqatntu.testutil.TestCode;
import com.sqatntu.testutil.TestConfig;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by andyccs on 11/10/15.
 */
public class BraceStyleListenerTest extends ListenerTest {

  @Test
  @TestCode(
      detail = "krStyleCode",
      fileName = "src/test/resources/stylechecker/BraceKRStyle.java")
  @TestConfig(
      detail = "krStyleConfig",
      fileName = "src/test/resources/stylechecker/BraceKRStyle.json")
  public void braceStyle1() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(0, report.getReportContents().size());
  }

  @Test
  @TestCode(
      detail = "krStyleCode",
      fileName = "src/test/resources/stylechecker/BraceKRStyle.java")
  @TestConfig(
      detail = "nonKrStyleConfig",
      fileName = "src/test/resources/stylechecker/BraceNonKRStyle.json")
  public void braceStyle2() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(4, report.getReportContents().size());
  }

  @Test
  @TestCode(
      detail = "krStyleCode",
      fileName = "src/test/resources/stylechecker/BraceKRStyle.java")
  @TestConfig(
      detail = "ignoreConfig",
      fileName = "src/test/resources/stylechecker/ignoreAll.json")
  public void braceStyle3() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(0, report.getReportContents().size());
  }

  @Test
  @TestCode(
      detail = "NonKrStyleCode",
      fileName = "src/test/resources/stylechecker/BraceNonKRStyle.java")
  @TestConfig(
      detail = "krStyleConfig",
      fileName = "src/test/resources/stylechecker/BraceKRStyle.json")
  public void braceStyle4() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(4, report.getReportContents().size());
  }

  @Test
  @TestCode(
      detail = "NonKrStyleCode",
      fileName = "src/test/resources/stylechecker/BraceNonKRStyle.java")
  @TestConfig(
      detail = "nonKrStyleConfig",
      fileName = "src/test/resources/stylechecker/BraceNonKRStyle.json")
  public void braceStyle5() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(0, report.getReportContents().size());
  }

  @Test
  @TestCode(
      detail = "NonKrStyleCode",
      fileName = "src/test/resources/stylechecker/BraceNonKRStyle.java")
  @TestConfig(
      detail = "ignoreConfig",
      fileName = "src/test/resources/stylechecker/ignoreAll.json")
  public void braceStyle6() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(0, report.getReportContents().size());
  }

  @Test
  @TestCode(
      detail = "krStyleCodeInterface",
      fileName = "src/test/resources/stylechecker/BraceKRStyleInterface.java")
  @TestConfig(
      detail = "krStyleConfig",
      fileName = "src/test/resources/stylechecker/BraceKRStyle.json")
  public void braceStyle7() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(0, report.getReportContents().size());
  }

  @Test
  @TestCode(
      detail = "krStyleCodeInterface",
      fileName = "src/test/resources/stylechecker/BraceKRStyleInterface.java")
  @TestConfig(
      detail = "nonKrStyleConfig",
      fileName = "src/test/resources/stylechecker/BraceNonKRStyle.json")
  public void braceStyle8() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(1, report.getReportContents().size());
  }

  @Test
  @TestCode(
      detail = "krStyleCodeInterface",
      fileName = "src/test/resources/stylechecker/BraceKRStyleInterface.java")
  @TestConfig(
      detail = "ignoreConfig",
      fileName = "src/test/resources/stylechecker/ignoreAll.json")
  public void braceStyle9() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(0, report.getReportContents().size());
  }

  @Test
  @TestCode(
      detail = "nonKrStyleCodeInterface",
      fileName = "src/test/resources/stylechecker/BraceNonKRStyleInterface.java")
  @TestConfig(
      detail = "krStyleConfig",
      fileName = "src/test/resources/stylechecker/BraceKRStyle.json")
  public void braceStyle10() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(1, report.getReportContents().size());
  }

  @Test
  @TestCode(
      detail = "nonKrStyleCodeInterface",
      fileName = "src/test/resources/stylechecker/BraceNonKRStyleInterface.java")
  @TestConfig(
      detail = "nonKrStyleConfig",
      fileName = "src/test/resources/stylechecker/BraceNonKRStyle.json")
  public void braceStyle11() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(0, report.getReportContents().size());
  }

  @Test
  @TestCode(
      detail = "nonKrStyleCodeInterface",
      fileName = "src/test/resources/stylechecker/BraceNonKRStyleInterface.java")
  @TestConfig(
      detail = "ignoreConfig",
      fileName = "src/test/resources/stylechecker/ignoreAll.json")
  public void braceStyle12() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(0, report.getReportContents().size());
  }

  @Test
  @TestCode(
      detail = "kRStyleTryCatchFinally",
      fileName = "src/test/resources/stylechecker/BraceKRStyleTryCatchFinally.java")
  @TestConfig(
      detail = "krStyleConfig",
      fileName = "src/test/resources/stylechecker/BraceKRStyle.json")
  public void braceStyle13() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(0, report.getReportContents().size());
  }

  @Test
  @TestCode(
      detail = "kRStyleTryCatchFinally",
      fileName = "src/test/resources/stylechecker/BraceKRStyleTryCatchFinally.java")
  @TestConfig(
      detail = "nonKrStyleConfig",
      fileName = "src/test/resources/stylechecker/BraceNonKRStyle.json")
  public void braceStyle14() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(5, report.getReportContents().size());
  }

  @Test
  @TestCode(
      detail = "nonKRStyleTryCatchFinally",
      fileName = "src/test/resources/stylechecker/BraceNonKRStyleTryCatchFinally.java")
  @TestConfig(
      detail = "nonKrStyleConfig",
      fileName = "src/test/resources/stylechecker/BraceNonKRStyle.json")
  public void braceStyle15() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(0, report.getReportContents().size());
  }

  @Test
  @TestCode(
      detail = "nonKRStyleTryCatchFinally",
      fileName = "src/test/resources/stylechecker/BraceNonKRStyleTryCatchFinally.java")
  @TestConfig(
      detail = "krStyleConfig",
      fileName = "src/test/resources/stylechecker/BraceKRStyle.json")
  public void braceStyle16() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(5, report.getReportContents().size());
  }
}
