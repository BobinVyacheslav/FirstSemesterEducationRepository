package com.mipt.vyacheslavbobin.homeworkCollections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomArrayList<A> implements CustomList<A>, Iterable<A> {
  private Object[] data = new Object[15];
  private int len = 15;
  private int size = 0;

  /**
   * @return итератор для коллекции
   */
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

  /**
   * Добавляет элемент в коллекцию, расширяет массив по необходимости
   * @param element добавляемый элемент, не null
   *
   */
  @Override
  public void add(A element) {
    if (element == null) {
      throw new NullPointerException();
    }
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

  /**
   * возвращает элемент по индексу
   * @param index
   * @return значение элемента по индексу
   */
  @Override
  public A get(int index) {
    return (A) data[index];
  }

  /**
   * удаляет элемент по индексу, смещает последующие влево
   * уменьшает размер на 1
   * @param index
   * если индекс не входит в коллекцию, не делает ничего
   */
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

  /**
   * возвращает размер коллекции
   * @return размер
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * @return пуста ли коллекция
   */
  @Override
  public boolean isEmpty() {
    return (size == 0);
  }
}
