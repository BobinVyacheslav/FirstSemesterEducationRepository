package com.mipt.vyacheslavbobin.homeworkCollections;

import java.util.Objects;

public class Student {
  public int id;
  public String name;
  public double grade;
  Student(int id, String name, double grade) {
    this.id = id;
    this.name = name;
    this.grade = grade;
  }
  @Override
  public boolean equals(Object o){
    if (this == o) {
      return true;
    } else if (o == null || o.getClass() != this.getClass()) {
      return false;
    }
    Student second = (Student) o;
    return this.id == second.id
            && this.name.equals(second.name)
            && Double.compare(this.grade, second.grade) == 0;
  }
  @Override
  public int hashCode() {
    return Objects.hash(id, name, grade);
  }

  public double getGrade() {
    return grade;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
