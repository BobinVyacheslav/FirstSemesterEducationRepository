package com.mipt.vyacheslavbobin.homeworkCollections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayListTest {
  @Test
  public void testAdd() {
    CustomList<Integer> list = new CustomArrayList<>();
    for (int i = 0; i < 31; i++) {
      list.add(i * i);
    }
    for (int i = 0; i < 31; i++) {
      assertEquals(i * i, list.get(i));
    }
  }

  @Test
  public void testGet() {
    CustomList<String> list = new CustomArrayList<>();
    for (int i = 0; i < 43; i++) {
      list.add(String.valueOf(i * 7 + 3));
    }
    for (int i = 0; i < 43; i++) {
      assertEquals(String.valueOf(7 * i + 3), list.get(i));
    }
  }

  @Test
  public void testRemove() {
    CustomList<Integer> list = new CustomArrayList<>();
    CustomList<Integer> correct = new CustomArrayList<>();
    for (int i = 0; i < 56; i++) {
      list.add(i * 2);
      if (i != 43 && i != 55) {
        correct.add(i * 2);
      }
    }
    list.remove(55);
    list.remove(43);
    assertEquals(correct.size(), list.size());
    for (int i = 0; i < correct.size(); i++) {
      assertEquals(correct.get(i), list.get(i));
    }
  }
  @Test
  public void testSize() {
    CustomList<Integer> list = new CustomArrayList<>();
    int size = 4883;
    for (int i = 0; i<size; i++) {
      list.add(i);
    }
    assertEquals(size, list.size());
  }
  @Test
  public void testIsEmpty() {
    CustomList<Integer> list = new CustomArrayList<>();
    CustomList<Integer> empty = new CustomArrayList<>();
    int size = 98;
    for (int i = 0; i<size; i++) {
      list.add(i);
    }
    assertEquals(false, list.isEmpty());
    assertEquals(true, empty.isEmpty());
  }
}