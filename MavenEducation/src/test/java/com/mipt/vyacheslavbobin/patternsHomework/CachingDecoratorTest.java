package com.mipt.vyacheslavbobin.patternsHomework;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class CachingDecoratorTest {

  private DataService simpleDataService;
  private CachingDecorator cachingDecorator;

  @BeforeEach
  void setUp() {
    simpleDataService = new SimpleDataService();
    cachingDecorator = new CachingDecorator(simpleDataService);
  }

  @Test
  void testSaveAndFindWithCache() {
    cachingDecorator.saveData("key1", "data1");

    assertTrue(cachingDecorator.findDataByKey("key1").isPresent());
    assertEquals("data1", cachingDecorator.findDataByKey("key1").get());
  }

  @Test
  void testFindWithCache() {
    cachingDecorator.saveData("key1", "data1");

    assertTrue(cachingDecorator.findDataByKey("key1").isPresent());
    assertEquals("data1", cachingDecorator.findDataByKey("key1").get());

    cachingDecorator.saveData("key2", "data2");
    assertTrue(cachingDecorator.findDataByKey("key2").isPresent());
    assertEquals("data2", cachingDecorator.findDataByKey("key2").get());

    assertTrue(cachingDecorator.findDataByKey("key1").isPresent());
    assertEquals("data1", cachingDecorator.findDataByKey("key1").get());
  }

  @Test
  void testCacheAfterDeletion() {
    cachingDecorator.saveData("key1", "data1");

    assertTrue(cachingDecorator.findDataByKey("key1").isPresent());
    assertEquals("data1", cachingDecorator.findDataByKey("key1").get());

    cachingDecorator.deleteData("key1");
    assertFalse(cachingDecorator.findDataByKey("key1").isPresent());
  }

  @Test
  void testCacheUpdatedAfterSave() {
    cachingDecorator.saveData("key1", "data1");

    assertTrue(cachingDecorator.findDataByKey("key1").isPresent());
    assertEquals("data1", cachingDecorator.findDataByKey("key1").get());

    cachingDecorator.saveData("key1", "updatedData");

    assertTrue(cachingDecorator.findDataByKey("key1").isPresent());
    assertEquals("updatedData", cachingDecorator.findDataByKey("key1").get());
  }

  @Test
  void testCacheForNonExistentData() {
    assertFalse(cachingDecorator.findDataByKey("nonExistentKey").isPresent());
  }
}


