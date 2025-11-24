package com.mipt.vyacheslavbobin.multithreadingHomework;

public class BankAccount {
  private String name;
  private int balance;
  public BankAccount(int balance, String name) {
    this.balance = balance;
    this.name = name;
  }
  public BankAccount() {
    this.balance = 0;
    this.name = "joe";
  }
  public void add(int sum) {
    if (sum < 0) {
      throw new IllegalArgumentException("Нельзя внести отрицательную сумму");
    }
    this.balance += sum;
  }

  public void withdraw(int sum) {
    if (sum < 0) {
      throw new IllegalArgumentException("Нельзя вывести отрицательную сумму");
    }
    if (sum > balance) {
      throw new IllegalArgumentException("Не хватает средств");
    }
    balance -= sum;
  }
  public String getName() {
    return name;
  }
  public int getBalance() {
    return balance;
  }


}
