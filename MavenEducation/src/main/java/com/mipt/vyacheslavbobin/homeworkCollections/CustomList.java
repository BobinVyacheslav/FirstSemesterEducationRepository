package com.mipt.vyacheslavbobin.homeworkCollections;

public interface CustomList<A> {
  /**
   * @param element
   * добавляет элемент в коллекцию, расширяет коллекцию по необходимости
   */
  void add(A element);

  /**
   * @param index
   * @return элемент по индексу
   */
  A get(int index);

  /**
   * @param index удаляет по индексу
   */
  void remove(int index);

  /** возвращает размер коллекциюъи
   * @return размер
   */
  int size();

  /**
   * @return пуста ли коллекция
   */
  boolean isEmpty();
}