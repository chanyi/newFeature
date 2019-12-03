package com.simba.java8.model;

@FunctionalInterface
public interface FunctionalInterfaceModel2 {

  int count = 0;
  //接口中的变量都是 静态常量的类型。这样定义的意义在于：
  //  1、在于接口是抽象定义不变的属性，可变的属性应该放入实现类中
  //  2、如果变量定义为非静态的，那么接口的实现类如果继承多个接口，多个接口中存在相同名称的变量，则无法区分
  //     而如果是静态的，则直接通过类去调用，通过接口的类名区分相同名称的不同变量
  //  3、
  public static  final  int countTest = 0;

  void fi();

  static  void test1(){
    System.out.println("test1");
  }

  default  void defaultMethod(){
    System.out.println("defaultMethod");
  }
}
