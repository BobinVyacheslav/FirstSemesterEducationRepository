package com.mipt.vyacheslavbobin.genericsHomework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
  Calculator<Integer> integerCalculator = new Calculator<>();
  Calculator<Double> doubleCalculator = new Calculator<>();
  @Test
  public void sumTest() {

    assertEquals(9.0, integerCalculator.sum(4, 5));
    assertEquals(14.0, doubleCalculator.sum(8.0, 6.0));
    assertEquals(Double.NaN, integerCalculator.sum(null, 8));

  }
  @Test
  public void divideTest() {
    assertEquals(4.0, integerCalculator.divide(8, 2));
    assertEquals(Double.NaN, integerCalculator.divide(null, 8));
    assertEquals(Double.NaN, integerCalculator.divide(8,0));
    assertEquals(Double.NaN, doubleCalculator.divide(8.0, 0.0));
  }

}