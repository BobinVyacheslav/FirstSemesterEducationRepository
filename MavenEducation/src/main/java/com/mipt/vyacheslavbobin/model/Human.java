package com.mipt.vyacheslavbobin.model;

public class Human {
    private String name;
    private String lastName;
    private int age;
    private boolean isEmployed;
    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void setIsEmployed(boolean isEmployed) {
        this.isEmployed = isEmployed;
    }
    public boolean getIsEmployed() {
        return isEmployed;
    }
}
