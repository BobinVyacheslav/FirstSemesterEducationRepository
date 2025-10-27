package com.mipt.vyacheslavbobin.annotationsHomework;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Range {
  int min() default 0;
  int max() default Integer.MAX_VALUE;
  String message();

}
