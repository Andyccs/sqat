/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Andy Chong Chin Shin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software
 * is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.sqatntu.stylechecker.listener;

import static org.junit.Assert.assertEquals;

import com.sqatntu.stylechecker.JavaStyleChecker;
import com.sqatntu.stylechecker.configuration.Configuration;
import com.sqatntu.stylechecker.configuration.ConfigurationLoader;
import com.sqatntu.stylechecker.configuration.DefaultConfiguration;
import com.sqatntu.stylechecker.configuration.StyleName;
import com.sqatntu.stylechecker.injection.Dagger;
import com.sqatntu.stylechecker.injection.StyleCheckerModule;
import com.sqatntu.stylechecker.report.StyleReport;
import dagger.Module;
import dagger.Provides;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import javax.inject.Singleton;

/**
 * Created by andyccs on 6/9/15.
 */
public class MethodNameFormatListenerTest {

  @Module(
      injects = {
          MethodNameFormatListenerTest.class,
          MethodNameFormatListener.class,
          JavaStyleChecker.class
      },
      includes = StyleCheckerModule.class,
      overrides = true)
  public class TestModule {

    @Provides
    @Singleton
    ConfigurationLoader provideConfigurationLoader() {
      return new ConfigurationLoader() {
        @Override
        public Configuration loadConfiguration() {
          DefaultConfiguration configuration = new DefaultConfiguration();
          configuration.addAttribute(
              StyleName.METHOD_NAME_FORMAT,
              StyleName.METHOD_NAME_FORMAT_CAMEL_CASE);
          return configuration;
        }
      };
    }
  }

  @Before
  public void before() {
    Dagger.changeModule(new TestModule());
  }

  @Test
  public void methodNameFormatWithCamelCase() throws IOException {
    JavaStyleChecker checker = new JavaStyleChecker();
    StyleReport report = checker.check("src/test/resources/MethodNameFormatCamelCase.java");
    assertEquals(0, report.getReportContents().size());
  }
}
