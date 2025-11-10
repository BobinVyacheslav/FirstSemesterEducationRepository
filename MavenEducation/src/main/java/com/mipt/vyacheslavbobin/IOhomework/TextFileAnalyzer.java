package com.mipt.vyacheslavbobin.IOhomework;

import java.io.*;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class TextFileAnalyzer {

  public static class AnalysisResult {
    private final long lineCount;
    private final long wordCount;
    private final long charCount;
    private final Map<Character, Integer> frequencyMap;

    public Map<Character, Integer> getFrequencyMap() {
      return frequencyMap;
    }

    public AnalysisResult(long lineCount, long wordCount, long charCount, Map<Character, Integer> frequencyMap) {
      this.charCount = charCount;
      this.wordCount = wordCount;
      this.lineCount = lineCount;
      this.frequencyMap = frequencyMap;
    }

    @Override
    public String toString() {
      String result = "Lines in file: " + lineCount
              + "\nWords in file: " + wordCount
              + "\nChars in file: " + charCount;
      result += "\nCharacter Frequency:\n";
      for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
        result += (entry.getKey() + ": " + entry.getValue() + "\n");
      }
      return result;
    }


    public long getCharCount() {
      return charCount;
    }

    public long getWordCount() {
      return wordCount;
    }

    public long getLineCount() {
      return lineCount;
    }
  }

  public AnalysisResult analyzeFile(String filePath) throws IOException {
    Map<Character, Integer> frequencyMap = new HashMap<>();
    long charCount = 0;
    long wordCount = 0;
    long lineCount = 0;
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        String[] wordList = line.split("\\s+");
        wordCount += wordList.length;
        charCount += line.length();
        lineCount++;
        for (char c : line.toCharArray()) {
          frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

      }

    }
    return new AnalysisResult(lineCount, wordCount, charCount, frequencyMap);

  }

  public void saveAnalysisResult(AnalysisResult result, String outputPath) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
      writer.write("Lines in file: " + result.getLineCount() + "\n");
      writer.write("Words in file: " + result.getWordCount() + "\n");
      writer.write("Chars in file: " + result.getCharCount() + "\n");
      writer.write("\nCharacter Frequency\n");
      for (Map.Entry<Character, Integer> entry : result.getFrequencyMap().entrySet()) {
        writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
      }
    }
  }
}