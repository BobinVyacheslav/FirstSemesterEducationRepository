package com.mipt.vyacheslavbobin.annotationsHomework;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {
  private boolean isValid;
  private List<String> errors;
  ValidationResult() {
    this.isValid = true;
    errors = new ArrayList<>();
  }
  public void addError(String error) {
    errors.add(error);
    if (isValid) {
      isValid = false;
    }
  }
  public boolean isCorrect() {
    return isValid;
  }
  public int getNumberOfErrors() {
    return errors.size();
  }
  public List<String> getErrors() {
    return errors;
  }
  @Override
  public String toString() {
    if (isValid) {
      return "No errors";
    } else {
      String answer = "";
      for (String error: errors) {
        answer += (error);
      }
      return answer;
    }
  }

}
