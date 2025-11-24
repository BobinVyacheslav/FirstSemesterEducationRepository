package com.mipt.vyacheslavbobin.multithreadingHomework;

public class Bank {
  public Bank() {

  }
  public void transaction(BankAccount from, BankAccount to, int sum) {
    from.withdraw(sum);
    to.add(sum);
  }

  public void sendToAccountDeadlock(BankAccount from, BankAccount to, int amount) throws InterruptedException {
    synchronized (from) {
      Thread.sleep(20);
      synchronized (to) {
        transaction(from, to, amount);
      }
    }

  }

  public void sendToAccount(BankAccount from, BankAccount to, int amount) {
    BankAccount bigger;
    BankAccount smaller;
    if (from.getName().compareTo(to.getName()) < 0) {
      bigger = to;
      smaller = from;
    } else {
      bigger = from;
      smaller = to;
    }
    synchronized (bigger) {
      synchronized (smaller) {
        if (from.getBalance() < amount ) {
          throw new IllegalArgumentException("Недостаточно средств");
        }
        transaction(bigger, smaller, amount);
      }
    }

  }
}
