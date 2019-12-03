package com.simba.java8.controller;

import com.simba.java8.model.FunctionalInterfaceClass;
import com.simba.java8.model.FunctionalInterfaceModel;
import org.junit.Test;

/**
 * 默认方法：接口中有一个实现的方法（以前接口中不能有方法的实现）
 *  实用性在多个类共享一个接口方法
 *  优点：
 *    可以将共用的方法抽取出来，不用每个实现类都去实现
 *  缺点：
 *    不可以轻易修改默认方法
 *  目的：
 *    是为了解决jdk更新，接口的修改与现有的实现不兼容的情况
 */

public class DefaultMethodController {

  /**
   * 如果继承的两个接口有相同的默认方法，则实现类需要重写默认方法
   */
  @Test
  public void test(){
    FunctionalInterfaceClass functionalInterfaceClass = new FunctionalInterfaceClass();
    functionalInterfaceClass.defaultMethod();
    functionalInterfaceClass.defaultMethod1();
  }
}
