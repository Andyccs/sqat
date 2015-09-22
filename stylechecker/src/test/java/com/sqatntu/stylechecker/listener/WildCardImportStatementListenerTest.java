package com.sqatntu.stylechecker.listener;

import static org.junit.Assert.assertEquals;

import com.sqatntu.stylechecker.StyleChecker;
import com.sqatntu.stylechecker.report.StyleReport;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by andyccs on 22/9/15.
 */
public class WildCardImportStatementListenerTest {

  @Test
  public void importStatementsWithoutWildCard() throws IOException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.check(
        "src/test/resources/WildCardImportStatementNoWildCard.java",
        "src/test/resources/WildCardNotAllow.json");
    assertEquals(0, report.getReportContents().size());
  }

  @Test
  public void importStatementsHasWildCard() throws IOException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.check(
        "src/test/resources/WildCardImportStatementHasWildCard.java",
        "src/test/resources/WildCardNotAllow.json");
    assertEquals(2, report.getReportContents().size());
  }

  @Test
  public void importStatementsAllowWildCard() throws IOException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.check(
        "src/test/resources/WildCardImportStatementHasWildCard.java",
        "src/test/resources/WildCardAllow.json");
    assertEquals(0, report.getReportContents().size());
  }
}
