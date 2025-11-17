package com.mipt.vyacheslavbobin.patternsHomework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MetricableDecoratorTest {

  private DataService simpleDataService;
  private MetricableDecorator metricableDecorator;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  void setUp() {
    simpleDataService = new SimpleDataService();
    metricableDecorator = new MetricableDecorator(simpleDataService);
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @Test
  void testFindDataByKeyMetrics() {
    metricableDecorator.saveData("key1", "data1");

    outputStreamCaptor.reset();
    metricableDecorator.findDataByKey("key1");

    assertTrue(outputStreamCaptor.toString().contains("Метод выполнялся:"));
  }

  @Test
  void testSaveDataMetrics() {
    outputStreamCaptor.reset();
    metricableDecorator.saveData("key2", "data2");

    assertTrue(outputStreamCaptor.toString().contains("Метод выполнялся:"));
  }

  @Test
  void testDeleteDataMetrics() {
    metricableDecorator.saveData("key3", "data3");

    outputStreamCaptor.reset();
    metricableDecorator.deleteData("key3");

    assertTrue(outputStreamCaptor.toString().contains("Метод выполнялся:"));
  }

  @Test
  void testMetricsForMultipleOperations() {
    metricableDecorator.saveData("key4", "data4");
    metricableDecorator.findDataByKey("key4");
    metricableDecorator.deleteData("key4");

    String output = outputStreamCaptor.toString();

    assertTrue(output.contains("Метод выполнялся:"));
    assertTrue(output.split("\n").length >= 3);
  }
}
