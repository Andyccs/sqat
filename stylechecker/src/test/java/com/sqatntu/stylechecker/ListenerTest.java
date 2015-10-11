package com.sqatntu.stylechecker;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by andyccs on 11/10/15.
 */
public class ListenerTest {

  @Rule
  public TestName name = new TestName();

  protected String testCode;
  protected String testConfig;

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
}
