package com.mipt.vyacheslavbobin.annotationsHomework;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Email {
  String message();
}
