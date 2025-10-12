package com.mipt.vyacheslavbobin.genericsHomework;

public class Pair<K, V> {
  K key;
  V value;

  Pair(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return key;
  }

  public void setKey(K key) {
    this.key = key;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  public Pair<V, K> swap() {
    Pair<V, K> newPair = new Pair<>(value, key);
    return newPair;
  }

  @Override
  public String toString() {
    return ("Pair{key=" + key + ", value=" + value + "}");
  }

  public static void main(String[] args) {
    Pair<String, Integer> pair = new Pair<>("age", 25);
    System.out.println(pair);
    Pair<Integer, String> swapped = pair.swap();
    System.out.println(swapped);
    swapped.setKey(null);
    System.out.println(swapped.getKey());
    System.out.println(swapped);
  }
}
