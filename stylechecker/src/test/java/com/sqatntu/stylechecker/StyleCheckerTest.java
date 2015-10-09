package com.sqatntu.stylechecker;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by andyccs on 9/10/15.
 */
public class StyleCheckerTest {

  @Test(expected = StyleCheckerException.class)
  public void nonJavaCode() throws IOException, StyleCheckerException {
    String javascriptCode = TestUtil.loadFile("src/test/resources/NotJava.js");
    String randomConfig = TestUtil.loadFile("src/test/resources/NotJava.json");

    StyleChecker checker = new StyleChecker();
    checker.checkSourceCode(javascriptCode, randomConfig);
  }
}
