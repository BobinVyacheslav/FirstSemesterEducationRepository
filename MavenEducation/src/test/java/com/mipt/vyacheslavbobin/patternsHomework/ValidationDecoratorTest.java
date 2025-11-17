package com.mipt.vyacheslavbobin.patternsHomework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ValidationDecoratorTest {

  private DataService simpleDataService;
  private ValidationDecorator validationDecorator;

  @BeforeEach
  void setUp() {
    simpleDataService = new SimpleDataService();
    validationDecorator = new ValidationDecorator(simpleDataService);
  }

  @Test
  void testFindDataByKeyWithValidKey() {
    validationDecorator.saveData("key1", "data1");
    Optional<String> result = validationDecorator.findDataByKey("key1");
    assertTrue(result.isPresent());
    assertEquals("data1", result.get());
  }

  @Test
  void testFindDataByKeyWithInvalidKey() {
    assertThrows(IllegalArgumentException.class, () -> validationDecorator.findDataByKey(null));
    assertThrows(IllegalArgumentException.class, () -> validationDecorator.findDataByKey(""));
  }

  @Test
  void testSaveDataWithValidKeyAndData() {
    validationDecorator.saveData("key1", "data1");
    Optional<String> result = validationDecorator.findDataByKey("key1");
    assertTrue(result.isPresent());
    assertEquals("data1", result.get());
  }

  @Test
  void testSaveDataWithInvalidKey() {
    assertThrows(IllegalArgumentException.class, () -> validationDecorator.saveData(null, "data1"));
    assertThrows(IllegalArgumentException.class, () -> validationDecorator.saveData("", "data1"));
  }

  @Test
  void testSaveDataWithInvalidData() {
    assertThrows(IllegalArgumentException.class, () -> validationDecorator.saveData("key1", null));
    assertThrows(IllegalArgumentException.class, () -> validationDecorator.saveData("key1", ""));
  }

  @Test
  void testDeleteDataWithValidKey() {
    validationDecorator.saveData("key1", "data1");
    boolean result = validationDecorator.deleteData("key1");
    assertTrue(result);
  }

  @Test
  void testDeleteDataWithInvalidKey() {
    assertThrows(IllegalArgumentException.class, () -> validationDecorator.deleteData(null));
    assertThrows(IllegalArgumentException.class, () -> validationDecorator.deleteData(""));
  }
}
