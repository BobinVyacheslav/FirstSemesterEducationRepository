package com.mipt.vyacheslavbobin.homeworkCollections;

public interface CustomList<A> {
  void add(A element);
  A get(int index);
  void remove(int index);
  int size();
  boolean isEmpty();
}