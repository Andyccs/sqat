package com.sqatntu.stylechecker.injection;

import dagger.ObjectGraph;

/**
 * Created by andyccs on 6/9/15.
 */
public class Dagger {

  private static ObjectGraph objectGraph = ObjectGraph.create(new StyleCheckerModule());

  public static void inject(Object object) {
    objectGraph.inject(object);
  }
}
