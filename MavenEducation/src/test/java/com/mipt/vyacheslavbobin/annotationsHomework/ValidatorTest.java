package com.mipt.vyacheslavbobin.annotationsHomework;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
  @Test
  public void testCorrectObject() {
    TestingHuman human = new TestingHuman("sam", 100);
    TestingHuman second = new TestingHuman("friedrich", 34);
    ValidationResult listOfErrorsHuman = Validator.validate(human);
    ValidationResult listOfErrorsSecond = Validator.validate(second);
    assertEquals("No errors", listOfErrorsHuman.toString());
    assertEquals("No errors", listOfErrorsSecond.toString());
  }

  @Test
  public void testComplex() {
    ComplexHuman human = new ComplexHuman("jo", 122, "12345",
            "some@dude.com", null, 1222,
            188, "somewhere", 123);
    ValidationResult errorsList = Validator.validate(human);
    assertEquals(3, errorsList.getNumberOfErrors());
    assertTrue(errorsList.getErrors().contains("name — Name should be between 8 and 22 char.\n"));
  }

  @Test
  public void testNotNull() {
    ComplexHuman human = new ComplexHuman(null, null, "12345jhhkljhkjhjjh",
            "some@dude.com", "kfaljfajflkajfljalfj@kfjla.ej", null,
            188, null, null);
    ValidationResult errorsList = Validator.validate(human);
    assertEquals(4, errorsList.getNumberOfErrors());
    for (String element : errorsList.getErrors()) {
      assertTrue(element.contains("Null is not allowed"));
    }

  }

  @Test
  public void testEmail() {
    ComplexHuman human = new ComplexHuman("joejoejoe", 122, "1234kajfljals5",
            "incorrect_email", "incorrect_email", 1222,
            188, "somewhere", 123);
    ValidationResult errorsList = Validator.validate(human);
    for (String error : errorsList.getErrors()) {
      assertTrue(error.contains("Should be correct email"));
    }
  }

  @Test
  public void testSize() {
    ComplexHuman human = new ComplexHuman("joe", 122, "1234",
            "correct@email.com", "correct@example.email", 1222,
            188, "somewhere", 123);
    ValidationResult errorsList = Validator.validate(human);
    for (String error : errorsList.getErrors()) {
      assertTrue(error.contains("should be between") || error.contains("should be more than"));
    }
  }

  @Test
  public void testRange() {
    ComplexHuman human = new ComplexHuman("friedrich", 12892, "1234jfajlfd;s",
            "correct@email.com", "correct@example.email", 1222,
            1999, "somewhere", 123);
    ValidationResult errorsList = Validator.validate(human);
    for (String error : errorsList.getErrors()) {
      assertTrue(error.contains("Should be between") || error.contains("should be less than"));
    }
  }

  @Test
  public void testMultipleErrors() {
    ComplexHuman human = new ComplexHuman("friedrich", 22, "1234jfajlfd;s",
            "123too_long_to_be_correct_too_long_to_be_correct_too_long_to_be_correct_fjlkajfkljfkajf3803920392093fafdfadfafdfdjkljfajfkjadf",
            "correct@example.email", 1222,
            199, "somewhere", 123);
    ValidationResult errorsList = Validator.validate(human);
    for (String error : errorsList.getErrors()) {
      assertTrue(error.contains("Should be less than") && error.contains("Should be correct email"));
    }
    ComplexHuman human2 = new ComplexHuman("friedrich", 22, "1234jfajlfd;s",
            null,
            null, 1222,
            199, "somewhere", 123);
    ValidationResult errorsList2 = Validator.validate(human2);
    for (String error : errorsList2.getErrors()) {
      assertTrue(error.contains("Null is not allowed") && error.contains("Should be correct email"));
    }
  }
  @Test
  public void testBorderCases() {
    TestingHuman human = new TestingHuman("joe", 120);
    ValidationResult errorsList = Validator.validate(human);
    assertEquals(0, errorsList.getNumberOfErrors());
    assertTrue(errorsList.isCorrect());
    TestingHuman human1 = new TestingHuman("fourtyletterswordfourtyletterswordfourty", 0);
    ValidationResult errorsList1 = Validator.validate(human1);
    assertEquals(0, errorsList1.getNumberOfErrors());
    assertTrue(errorsList1.isCorrect());
  }


}