package com.mipt.vyacheslavbobin.patternsHomework;

import java.util.Optional;

public class LoggingDecorator implements DataService {
  private final DataService wrappedService;

  public LoggingDecorator(DataService wrappedService) {
    this.wrappedService = wrappedService;
  }

  @Override
  public Optional<String> findDataByKey(String key) {
    System.out.println("Attempt to find data by key: " + key);
    return wrappedService.findDataByKey(key);
  }

  @Override
  public void saveData(String key, String data) {
    System.out.println("attempt to save data: " + key + " = " + data);
    wrappedService.saveData(key, data);
  }

  @Override
  public boolean deleteData(String key) {
    System.out.println("Attempt to delete data by key: " + key);
    return wrappedService.deleteData(key);
  }
}

