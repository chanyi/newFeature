package com.simba.java8.model;

public class FunctionalInterfaceClass implements FunctionalInterfaceModel,FunctionalInterfaceModel2{

  @Override
  public void fi() {
    int count = FunctionalInterfaceModel.count;
    int count2 = FunctionalInterfaceModel2.count;
    System.out.println("function interface class");
  }

  @Override
  public void defaultMethod() {
    System.out.println("FunctionalInterfaceClass");
  }

  public void defaultMethod1() {
    FunctionalInterfaceModel.super.defaultMethod1();
    FunctionalInterfaceModel.staticMethod();
  }
}
