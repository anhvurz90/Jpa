package com.anhvurz90.jpaDumpData.writer;

import java.io.IOException;
import java.util.List;

public interface Writer<E> {

  void writeToFile(String fileName, List<E> entity) throws IOException;
}
