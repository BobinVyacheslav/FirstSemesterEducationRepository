package com.mipt.vyacheslavbobin.patternsHomework;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class CachingDecorator implements DataService {
  private final DataService wrappedService;
  private final Map<String, String> cache = new HashMap<>();

  public CachingDecorator(DataService wrappedService) {
    this.wrappedService = wrappedService;
  }

  @Override
  public Optional<String> findDataByKey(String key) {
    if (cache.containsKey(key)) {
      return Optional.of(cache.get(key));
    }
    Optional<String> result = wrappedService.findDataByKey(key);
    cache.put(key, String.valueOf(result));
    return result;
  }

  @Override
  public void saveData(String key, String data) {
    wrappedService.saveData(key, data);
    cache.put(key, data);
  }

  @Override
  public boolean deleteData(String key) {
    boolean result = wrappedService.deleteData(key);
    cache.remove(key);
    return result;
  }
}
