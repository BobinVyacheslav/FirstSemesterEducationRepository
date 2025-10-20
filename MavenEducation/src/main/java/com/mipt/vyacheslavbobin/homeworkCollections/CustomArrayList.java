package com.mipt.vyacheslavbobin.homeworkCollections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomArrayList<A> implements CustomList<A>, Iterable<A> {
  private Object[] data = new Object[15];
  private int len = 15;
  private int size = 0;

  @Override
  public Iterator<A> iterator() {
    return new LocalIterator();
  }

  public class LocalIterator implements Iterator<A> {
    private int currentIndex = 0;

    @Override
    public boolean hasNext() {
      return currentIndex < size;
    }

    public A next() {
      if (hasNext()) {
        return (A) data[currentIndex++];
      } else {
        throw new NoSuchElementException();
      }
    }
  }

  @Override
  public void add(A element) {
    if (size < len) {
      data[size] = element;
      size++;
    } else {
      Object[] newData = new Object[(len * 3) / 2];
      for (int i = 0; i < len; i++) {
        newData[i] = data[i];
      }
      newData[size] = element;
      size++;
      len = (3 * len) / 2;
      data = newData;
    }
  }

  @Override
  public A get(int index) {
    return (A) data[index];
  }

  @Override
  public void remove(int index) {
    if (index >= size) {
      return;
    }
    Object[] newData = new Object[len];
    for (int i = 0; i < index; i++) {
      newData[i] = data[i];
    }
    for (int i = index + 1; i < size; i++) {
      newData[i - 1] = data[i];
    }
    data = newData;
    size--;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return (size == 0);
  }
}
