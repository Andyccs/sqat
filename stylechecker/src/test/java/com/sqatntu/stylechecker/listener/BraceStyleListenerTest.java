package com.sqatntu.stylechecker.listener;

import static org.junit.Assert.assertEquals;

import com.sqatntu.stylechecker.StyleChecker;
import com.sqatntu.stylechecker.StyleCheckerException;
import com.sqatntu.stylechecker.TestCode;
import com.sqatntu.stylechecker.TestConfig;
import com.sqatntu.stylechecker.TestUtil;
import com.sqatntu.stylechecker.report.StyleReport;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by andyccs on 11/10/15.
 */
public class BraceStyleListenerTest {

  @Rule
  public TestName name = new TestName();

  private String testCode;
  private String testConfig;

  @Before
  public void before() throws NoSuchMethodException, IOException {
    Method method = this.getClass().getMethod(name.getMethodName());
    Annotation[] annotations = method.getDeclaredAnnotations();

    for(Annotation annotation : annotations) {
      if(annotation instanceof TestCode){
        TestCode testCodeAnnotation = (TestCode) annotation;
        testCode = TestUtil.loadFile(testCodeAnnotation.fileName());
      }
      else if(annotation instanceof TestConfig) {
        TestConfig testConfigAnnotation = (TestConfig) annotation;
        testConfig = TestUtil.loadFile(testConfigAnnotation.fileName());
      }
    }
  }

  @After
  public void after() {
    testCode = null;
    testConfig = null;
  }

  @Test
  @TestCode(detail = "krStyleCode", fileName = "src/test/resources/BraceKRStyle.java")
  @TestConfig(detail = "krStyleConfig", fileName = "src/test/resources/BraceKRStyle.json")
  public void braceStyle1() throws IOException, StyleCheckerException {
    StyleChecker checker = new StyleChecker();
    StyleReport report = checker.checkSourceCode(testCode, testConfig);
    assertEquals(0, report.getReportContents().size());
  }
}
