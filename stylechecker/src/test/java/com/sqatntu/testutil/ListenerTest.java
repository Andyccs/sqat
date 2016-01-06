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

package com.sqatntu.testutil;

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

    for (Annotation annotation : annotations) {
      if (annotation instanceof TestCode) {
        TestCode testCodeAnnotation = (TestCode) annotation;
        testCode = TestUtil.loadFile(testCodeAnnotation.fileName());
      } else if (annotation instanceof TestConfig) {
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
