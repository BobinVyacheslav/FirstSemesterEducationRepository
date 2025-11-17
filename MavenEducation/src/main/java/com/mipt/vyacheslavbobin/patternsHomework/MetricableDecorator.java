package com.mipt.vyacheslavbobin.patternsHomework;

import java.time.Duration;
import java.util.Optional;

public class MetricableDecorator implements DataService {
  private final DataService wrappedService;
  private final MetricService metricService = new MetricService();

  public MetricableDecorator(DataService wrappedService) {
    this.wrappedService = wrappedService;
  }

  public static class MetricService {
    public void sendMetric(Duration duration) {
      System.out.println("Метод выполнялся: " + duration.toString());
    }
  }

  @Override
  public Optional<String> findDataByKey(String key) {
    long startTime = System.nanoTime();
    Optional<String> result = wrappedService.findDataByKey(key);
    long endTime = System.nanoTime();
    metricService.sendMetric(Duration.ofNanos(endTime - startTime));
    return result;
  }

  @Override
  public void saveData(String key, String data) {
    long startTime = System.nanoTime();
    wrappedService.saveData(key, data);
    long endTime = System.nanoTime();
    metricService.sendMetric(Duration.ofNanos(endTime - startTime));
  }

  @Override
  public boolean deleteData(String key) {
    long startTime = System.nanoTime();
    boolean result = wrappedService.deleteData(key);
    long endTime = System.nanoTime();
    metricService.sendMetric(Duration.ofNanos(endTime - startTime));
    return result;
  }
}

