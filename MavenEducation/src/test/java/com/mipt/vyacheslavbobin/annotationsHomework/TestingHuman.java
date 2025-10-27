package com.mipt.vyacheslavbobin.annotationsHomework;

public class TestingHuman {
  @NotNull(message = "shouldn't be null")
  @Size(min = 3, max = 40, message = "should be between 3 and 40 characters")
  String name;
  @NotNull(message = "shouldn't be null")
  @Range(max = 120, message = "should be between 0 and 120")
  Integer age;

  TestingHuman(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

}
