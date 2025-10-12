package com.mipt.vyacheslavbobin.genericsHomework;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollectionUtilsTest {
  @Test
  public void testAddAllArrayList() {
    ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(8, 3, 5, 4, 9));
    ArrayList<Integer> empty = new ArrayList<>();
    CollectionUtils.addAll(list1, list2);
    ArrayList<Integer> answ = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 8, 3, 5, 4, 9));
    assertEquals(answ, list1);
    CollectionUtils.addAll(list1, empty);
    assertEquals(answ, list1);
  }
  @Test
  public void testAddAllLinkedList() {
    LinkedList<Integer> linkedList1 = new LinkedList<>(Arrays.asList(2, 9));
    LinkedList<Integer> linkedList2 = new LinkedList<>(Arrays.asList(7, 8));
    LinkedList<Integer> answ = new LinkedList<>(Arrays.asList(2, 9, 7, 8));
    CollectionUtils.addAll(linkedList1, linkedList2);
    assertEquals(answ, linkedList1);
  }
  @Test
  public void testMergeLists() {
    List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> list2 = Arrays.asList(8, 3, 5, 4, 9);
    List<Integer> answ = Arrays.asList(1, 2, 3, 4, 5, 8, 3, 5, 4, 9);
    List<Integer> merged = CollectionUtils.mergeLists(list1, list2);
    assertEquals(answ, merged);

  }
}