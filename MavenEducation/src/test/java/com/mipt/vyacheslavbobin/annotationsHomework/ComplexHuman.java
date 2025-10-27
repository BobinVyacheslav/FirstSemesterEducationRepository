package com.mipt.vyacheslavbobin.annotationsHomework;

public class ComplexHuman {
  @Size(min = 8, max = 22, message = "Name should be between 8 and 22 char.")
  @NotNull(message =  "Null is not allowed")
  private String name;
  @Range(max = 130, message = "Age should be less than 130")
  @NotNull(message = "Null is not allowed")
  private Integer age;
  @Size(min = 10, message = "Password should be more than 10 char.")
  private String password;
  @Email(message = "Should be correct email")
  @Size(max = 100, message = "Should be less than 100 char.")
  @NotNull(message = "Null is not allowed")
  private String firstEmail;
  @Email(message = "Should be correct email")
  @NotNull(message =  "Null is not allowed")
  private String secondEmail;
  private Integer salary;
  @Range(min = 100, max = 300, message = "Should be between 100 and 300 cm")
  private Integer height;
  @NotNull(message = "Null is not allowed")
  private String address;
  @NotNull(message = "Null is not allowed")
  private Integer id;

  public ComplexHuman(String name, Integer age, String password,
                      String firstEmail, String secondEmail,
                      Integer salary, Integer height,
                      String address, Integer id) {
    this.name = name;
    this.age = age;
    this.password = password;
    this.firstEmail = firstEmail;
    this.secondEmail = secondEmail;
    this.salary = salary;
    this.height = height;
    this.address = address;
    this.id = id;
  }
}
