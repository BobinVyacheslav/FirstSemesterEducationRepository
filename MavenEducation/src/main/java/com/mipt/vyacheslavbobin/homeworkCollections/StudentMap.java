package com.mipt.vyacheslavbobin.homeworkCollections;

import java.util.*;

public class StudentMap {
  public static void main(String[] args){
    HashMap<Integer, Student> map = new HashMap<>();
    map.put(1, new Student(1, "Joe", 5.8));
    map.put(5, new Student(5, "Stuart", 8.4));
    map.put(4, new Student(4, "Jane", 7.5));
    map.put(7, new Student(7, "Sam", 6.8));

    TreeMap<Integer, Student> treeMap = new TreeMap<>(Comparator.reverseOrder());
    treeMap.putAll(map);
    List<Student> topNStudents = MapUtil.getTopNStudents(treeMap, 2);
    for (Student el: topNStudents) {
      System.out.println(el.getId());
    }
    List<Student> inRange = MapUtil.findStudentsByGradeRange(map, 6.0, 8.0);
    for (Student el: inRange) {
      System.out.println(el.getId());
    }



  }
}
