package com.mipt.vyacheslavbobin.genericsHomework;

public class Calculator<T extends Number> {
  public double sum(T a, T b) {
    if (a == null || b == null) {
      return Double.NaN;
    }
    return a.doubleValue() + b.doubleValue();
  }

  public double subtract(T a, T b) {
    if (a == null || b == null) {
      return Double.NaN;
    }
    return a.doubleValue() - b.doubleValue();
  }

  public double multiply(T a, T b) {
    if (a == null || b == null) {
      return Double.NaN;
    }
    return a.doubleValue() * b.doubleValue();
  }

  public double divide(T a, T b) {
    if (a == null || b == null) {
      return Double.NaN;
    }
    if (b.doubleValue() == 0.0) {
      return Double.NaN;
    } else {
      return a.doubleValue() / b.doubleValue();
    }
  }
//  public static void main(String[] args){
//    Calculator<Integer> integerCalculator = new Calculator<>();
//    System.out.println(integerCalculator.sum(5, 3));
//    System.out.println(integerCalculator.subtract(5, 3));
//    System.out.println(integerCalculator.multiply(5, 3));
//    System.out.println(integerCalculator.divide(5, 0));
//    System.out.println(integerCalculator.divide(5,3));
//    System.out.println(integerCalculator.subtract(null, 8));
//    Calculator<Double> doubleCalculator = new Calculator<>();
//    System.out.println(doubleCalculator.divide(5.0,0.0));
//  }
}
