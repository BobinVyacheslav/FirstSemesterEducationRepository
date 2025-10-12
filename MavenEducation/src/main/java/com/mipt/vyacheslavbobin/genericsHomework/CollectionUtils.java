package com.mipt.vyacheslavbobin.genericsHomework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionUtils {
  public static <T> void addAll(List<? super T> destination, List<? extends T> source) {
    if (destination == null || source == null || source.isEmpty()) {
      return;
    } else {
      for (T element : source) {
        destination.add(element);
      }
    }
  }

  public static <T> List<T> mergeLists(List<? extends T> list1, List<? extends T> list2) {
    List<T> mergedList = new ArrayList<>();
    addAll(mergedList, list1);
    addAll(mergedList, list2);
    return mergedList;

  }
}
