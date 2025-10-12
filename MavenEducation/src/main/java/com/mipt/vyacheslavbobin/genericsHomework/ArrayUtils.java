package com.mipt.vyacheslavbobin.genericsHomework;

public class ArrayUtils {
  public static <T> int findFirst(T[] array, T element){
    if (array == null) {
      return -1;
    }
    for (int i = 0; i<array.length; i++) {
      if (array[i] == null && element == null) {
        return i;
      } else if (array[i] == null && element != null) {
        continue;
      } else if (array[i].equals(element)) {
        return i;
      }
    }
    return -1;
  }
  public static void main(String[] args) {
    final String[] names = {"alice", "bob", null, "james"};
    System.out.println(ArrayUtils.findFirst(names, "alice"));
    System.out.println(ArrayUtils.findFirst(names, "joe"));
    System.out.println(ArrayUtils.findFirst(names, null));
    System.out.println(ArrayUtils.findFirst(null, null));
    final Integer[] mass = {1, null, 3, 5, 6, 4, 3, 5};
    System.out.println(ArrayUtils.findFirst(mass, 6));
    System.out.println(ArrayUtils.findFirst(mass, 7));
    System.out.println(ArrayUtils.findFirst(mass, null));
  }
}
