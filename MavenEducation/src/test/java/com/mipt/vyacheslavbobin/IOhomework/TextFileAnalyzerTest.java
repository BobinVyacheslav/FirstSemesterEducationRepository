package com.mipt.vyacheslavbobin.IOhomework;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TextFileAnalyzerTest {
  @Test
  void testAnalyzeFile() throws IOException {
    TextFileAnalyzer analyzer = new TextFileAnalyzer();


    Path testFile = Files.createTempFile("test", ".txt");
    Files.write(testFile, Arrays.asList("Hello world!", "This is test."));


    TextFileAnalyzer.AnalysisResult result = analyzer.analyzeFile(testFile.toString());

    assertEquals(2, result.getLineCount());
    assertEquals(5, result.getWordCount());
    assertEquals(25, result.getCharCount());
    assertTrue(result.getFrequencyMap().containsKey('i'));
    assertEquals(2, result.getFrequencyMap().get('i'));
    assertFalse(result.getFrequencyMap().containsKey('z'));
    System.out.println(result.toString());
  }

  @Test
  void testSaveAnalysisResult() throws IOException {
    TextFileAnalyzer analyzer = new TextFileAnalyzer();

    Map<Character, Integer> freq = new HashMap<>();
    freq.put('H', 1);
    freq.put('e', 1);
    freq.put('l', 3);
    freq.put('o', 11);
    freq.put(' ', 4);
    TextFileAnalyzer.AnalysisResult result = new TextFileAnalyzer.AnalysisResult(2, 5, 20, freq);


    Path outputFile = Files.createTempFile("analysis", ".txt");
    analyzer.saveAnalysisResult(result, outputFile.toString());


    assertTrue(Files.exists(outputFile));
    assertTrue(Files.size(outputFile) > 0);
    List<String> lines = Files.readAllLines(outputFile);

    assertTrue(lines.stream().anyMatch(line -> line.contains("Lines in file: 2")));
    assertTrue(lines.stream().anyMatch(line -> line.contains("Words in file: 5")));
    assertTrue(lines.stream().anyMatch(line -> line.contains("Chars in file: 20")));
    assertTrue(lines.stream().anyMatch(line -> line.contains("H: 1")));
    assertTrue(lines.stream().anyMatch(line -> line.contains("e: 1")));
    assertTrue(lines.stream().anyMatch(line -> line.contains("l: 3")));
    assertTrue(lines.stream().anyMatch(line -> line.contains("o: 11")));
    assertTrue(lines.stream().anyMatch(line -> line.contains(" : 4")));
  }

}