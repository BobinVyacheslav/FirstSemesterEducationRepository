package com.mipt.vyacheslavbobin.IOhomework;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {

  /**
   * Разбивает файл на части указанного размера
   *
   * @param sourcePath путь к исходному файлу
   * @param outputDir  директория для сохранения частей
   * @param partSize   размер каждой части в байтах
   * @return список путей к созданным частям
   */
  public List<Path> splitFile(String sourcePath, String outputDir, int partSize) throws IOException {
    List<Path> partPaths = new ArrayList<>();

    Path sourceFile = Paths.get(sourcePath);
    String originalName = sourceFile.getFileName().toString();
    String partName = originalName.substring(0, originalName.lastIndexOf('.')) + ".part";
    try (FileChannel fileChannel = FileChannel.open(sourceFile, StandardOpenOption.READ)) {
      long fileSize = fileChannel.size();
      long remainingSize = fileSize;
      int numberOfPart = 1;
      while (remainingSize > 0) {
        int currentPartSize;
        if (remainingSize < partSize) {
          currentPartSize = (int) remainingSize;
        } else {
          currentPartSize = partSize;
        }
        ByteBuffer byteBuffer = ByteBuffer.allocate(currentPartSize);
        fileChannel.read(byteBuffer);
        byteBuffer.flip();
        Path pathOfCurrentPart = Paths.get(outputDir, partName + numberOfPart);
        partPaths.add(pathOfCurrentPart);
        try (FileChannel outputChannel =
                     FileChannel.open(pathOfCurrentPart,
                             StandardOpenOption.CREATE,
                             StandardOpenOption.WRITE)) {
          outputChannel.write(byteBuffer);
          remainingSize -= currentPartSize;
          numberOfPart++;
        }
      }
    }
    return partPaths;
  }

  /**
   * Объединяет части файла обратно в один файл
   *
   * @param partPaths  список путей к частям файла (в правильном порядке)
   * @param outputPath путь для результирующего файла
   */
  public void mergeFiles(List<Path> partPaths, String outputPath) throws IOException {
    try (FileChannel outputChannel = FileChannel.open(Paths.get(outputPath),
            StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
      for (Path partPath : partPaths) {
        try (FileChannel inputChannel = FileChannel.open(partPath, StandardOpenOption.READ)) {
          ByteBuffer buffer = ByteBuffer.allocate(1024);


          while (inputChannel.read(buffer) != -1) {
            buffer.flip();
            outputChannel.write(buffer);
            buffer.clear();
          }
        }
      }
    }
  }
}
