package com.sqatntu.testutil;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by andyccs on 9/10/15.
 */
public class TestUtil {

  public static String loadFile(String filePath) throws IOException {
    File file = new File(filePath);
    return FileUtils.readFileToString(file);
  }
}
