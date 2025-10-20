package com.mipt.vyacheslavbobin.homeworkCollections;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapUtil {
  public static List<Student> findStudentsByGradeRange(Map<Integer, Student> map, double minGrade, double maxGrade){
    List<Student> answ = new ArrayList<>();
    for (Student element: map.values()){
      if (minGrade<=element.getGrade() && element.getGrade()<=maxGrade) {
        answ.add(element);
      }
    }
    return answ;
  }
  public static List<Student> getTopNStudents(TreeMap<Integer, Student> treeMap, int n) {
    List<Student> answ = new ArrayList<>();
    int i = 0;
    if (n<0) {
      throw new IndexOutOfBoundsException();
    }
    for (Map.Entry<Integer, Student> el: treeMap.entrySet()) {

      if (i>=n) {
        break;
      } else {
        answ.add(el.getValue());
        i++;
      }
    }
    return answ;
  }
}
