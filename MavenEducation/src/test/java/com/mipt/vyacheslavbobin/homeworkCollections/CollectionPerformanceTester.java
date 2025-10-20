package com.mipt.vyacheslavbobin.homeworkCollections;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CollectionPerformanceTester {
  private final int COUNT = 10_000;

  @Test
  @Order(1)
  void testAddToEnd() {
    System.out.printf("%-25s | %15s | %15s\n", "Название операции", "ArrayList", "LinkedList");
    timeOfCurrentTest("Добавление в конец", list -> {
      for (int i = 0; i < COUNT; i++) {
        list.add(i);
      }
    });
  }

  @Test
  @Order(2)
  void testAddToStart() {
    timeOfCurrentTest("Добавление в начало", list -> {
      for (int i = 0; i < COUNT; i++) {
        list.add(0, i);
      }
    });
  }

  @Test
  @Order(3)
  void testInsertToMiddle() {
    timeOfCurrentTest("Вставка в середину", list -> {
      for (int i = 0; i < COUNT; i++) {
        list.add(list.size() / 2, i);
      }
    });
  }

  @Test
  @Order(4)
  void testAccessByIndex() {
    timeOfCurrentTest("Доступ по индексу", list -> {
      for (int i = 0; i < COUNT; i++) {
        list.add(i);
      }
      for (int i = 0; i < COUNT; i++) {
        list.get(i);
      }
    });
  }

  @Test
  @Order(5)
  void testRemoveFromStart() {
    timeOfCurrentTest("Удаление с начала", list -> {
      for (int i = 0; i < COUNT; i++) {
        list.add(i);
      }
      while (!list.isEmpty()) {
        list.remove(0);
      }
    });
  }

  @Test
  @Order(6)
  void testRemoveFromEnd() {
    timeOfCurrentTest("Удаление с конца", list -> {
      for (int i = 0; i < COUNT; i++) {
        list.add(i);
      }
      while (!list.isEmpty()) {
        list.remove(list.size() - 1);
      }
    });
  }

  @FunctionalInterface
  interface Operation {
    void run(List<Integer> list);
  }

  private void timeOfCurrentTest(String name, Operation currTest) {
    List<Integer> arrayList = new ArrayList<>();
    List<Integer> linkedList = new LinkedList<>();

    long arrayListTime = measure(() -> currTest.run(arrayList));
    long linkedListTime = measure(() -> currTest.run(linkedList));

    System.out.printf("%-25s | %12d ms | %12d ms\n", name, arrayListTime, linkedListTime);
  }

  private long measure(Runnable task) {
    long start = System.nanoTime();
    task.run();
    long end = System.nanoTime();
    return (end - start) / 1_000_000;
  }


}
