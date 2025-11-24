package com.mipt.vyacheslavbobin.multithreadingHomework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
  Bank MtsBank;
  BankAccount joe, don, oleg, tchTech;


  @BeforeEach
  void setUp() {
    MtsBank = new Bank();
    joe = new BankAccount(100, "joe biden");
    don = new BankAccount(100000, "trump");
    oleg = new BankAccount(10000000, "fisherman998");
    tchTech = new BankAccount(1000000, "kirill");
  }


  @Test
  public void shouldDoNormalTransaction() {
    MtsBank.transaction(tchTech, oleg, 100);
    assertEquals(1000000 - 100, tchTech.getBalance());
    assertEquals(10000000 + 100, oleg.getBalance());
  }

  @Test
  public void testSendToAccountOneThread() {
    MtsBank.sendToAccount(don, joe, 100);
    assertEquals(100000 - 100, don.getBalance());
    assertEquals(200, joe.getBalance());
  }

  @Test
  public void testValid() {
    assertThrows(IllegalArgumentException.class,
            () -> MtsBank.sendToAccount(joe, don, 200));
    assertThrows(IllegalArgumentException.class,
            () -> MtsBank.sendToAccount(tchTech, oleg, -100));
  }

  @Test
  public void testSendToAccountMultithread() throws InterruptedException {
    long olegBalance = oleg.getBalance();
    long trumpBalance = don.getBalance();
    Thread olegToDon = new Thread(() -> {
      for (int i = 0; i < 1000; i++) {
        MtsBank.sendToAccount(oleg, don, 1);
      }
    });

    Thread DonToOleg = new Thread(() -> {
      for (int i = 0; i < 1000; i++) {
        MtsBank.sendToAccount(don, oleg, 1);
      }
    });

    olegToDon.start();
    DonToOleg.start();

    olegToDon.join();
    DonToOleg.join();

    assertEquals(olegBalance + trumpBalance, oleg.getBalance() + don.getBalance());
  }

  @Test
  void testSendToAccountDeadlock() throws InterruptedException {

    Thread thread = new Thread(() -> {
      try {
        for (int i = 0; i < 10; i++) {
          MtsBank.sendToAccountDeadlock(tchTech, oleg, 20);
        }
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });
    Thread thread2 = new Thread(() -> {
      try {
        for (int i = 0; i < 10; i++) {
          MtsBank.sendToAccountDeadlock(oleg, tchTech, 20);
        }
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });
    thread.start();
    thread2.start();
    thread2.join(2000);
    thread.join(2000);
    assertTrue(thread2.isAlive() && thread.isAlive());
  }

  @Test
  public void testManyThread() throws InterruptedException {
    long initSum = don.getBalance() + tchTech.getBalance() + joe.getBalance();
    Thread thread1 = new Thread(() -> {
      for (int i = 0; i < 98; i++) {
        MtsBank.sendToAccount(don, joe, 1);
      }
    });
    Thread thread2 = new Thread(() -> {
      for (int i = 0; i < 98; i++) {
        MtsBank.sendToAccount(joe, don, 1);
      }
    });
    Thread thread3 = new Thread(() -> {
      for (int i = 0; i<100; i++) {
        MtsBank.sendToAccount(tchTech, don, 2);
      }
    });
    Thread thread4 = new Thread(() -> {
      for (int i = 0; i<100; i++) {
        MtsBank.sendToAccount(don, tchTech, 2);
      }
    });
    thread4.start();
    thread3.start();
    thread2.start();
    thread1.start();
    thread4.join();
    thread1.join();
    thread3.join();
    thread2.join();
    assertEquals(initSum, joe.getBalance() + tchTech.getBalance() + don.getBalance());
    assertFalse(thread4.isAlive());
    assertFalse(thread3.isAlive());
    assertFalse(thread2.isAlive());
    assertFalse(thread1.isAlive());
  }



}