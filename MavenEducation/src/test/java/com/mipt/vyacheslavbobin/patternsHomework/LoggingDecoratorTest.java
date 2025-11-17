package com.mipt.vyacheslavbobin.patternsHomework;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class LoggingDecoratorTest {

  private DataService simpleDataService;
  private LoggingDecorator loggingDecorator;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  void setUp() {
    simpleDataService = new SimpleDataService();
    loggingDecorator = new LoggingDecorator(simpleDataService);
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @Test
  void testSaveDataLogsCorrectly() {
    loggingDecorator.saveData("key1", "data1");
    String expectedOutput = "attempt to save data: key1 = data1\n";
    assertEquals(expectedOutput, outputStreamCaptor.toString());
  }

  @Test
  void testFindDataLogsCorrectly() {
    loggingDecorator.saveData("key1", "data1");
    outputStreamCaptor.reset();
    loggingDecorator.findDataByKey("key1");
    String expectedOutput = "Attempt to find data by key: key1\n";
    assertEquals(expectedOutput, outputStreamCaptor.toString());
  }

  @Test
  void testDeleteDataLogsCorrectly() {
    loggingDecorator.saveData("key1", "data1");
    outputStreamCaptor.reset();
    loggingDecorator.deleteData("key1");
    String expectedOutput = "Attempt to delete data by key: key1\n";
    assertEquals(expectedOutput, outputStreamCaptor.toString());
  }

  @Test
  void testFindDataLogsWhenNotFound() {
    outputStreamCaptor.reset();
    loggingDecorator.findDataByKey("nonExistentKey");
    String expectedOutput = "Attempt to find data by key: nonExistentKey\n";
    assertEquals(expectedOutput, outputStreamCaptor.toString());
  }
}
