package com.mipt.vyacheslavbobin.genericsHomework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
  Calculator<Integer> integerCalculator = new Calculator<>();
  Calculator<Double> doubleCalculator = new Calculator<>();
  @Test
  public void sumTest() {

    assertEquals(integerCalculator.sum(4, 5), 9.0);
    assertEquals(doubleCalculator.sum(8.0, 6.0), 14.0);
    assertEquals(integerCalculator.sum(null, 8), Double.NaN);

  }
  @Test
  public void divideTest() {
    assertEquals(integerCalculator.divide(8, 2), 4.0);
    assertEquals(integerCalculator.divide(null, 8), Double.NaN);
    assertEquals(integerCalculator.divide(8,0), Double.NaN);
    assertEquals(doubleCalculator.divide(8.0, 0.0), Double.NaN);
  }

}