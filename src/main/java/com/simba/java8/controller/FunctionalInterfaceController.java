package com.simba.java8.controller;

import com.simba.java8.model.FunctionalInterfaceModel;
import java.util.Comparator;
import java.util.concurrent.Callable;
import org.junit.Test;

/**
 * 函数式接口
 *    有且仅有一个抽象方法，但可以有多非抽象方法(默认方法和静态方法，都有实现体)
 *     1.8前的抽象方法
 *        java.lang.Runnable
 *        java.util.concurrent.Callable
 *        java.security.PrivilegedAction
 *        java.util.Comparator
 *        java.io.FileFilter
 *        java.nio.file.PathMatcher
 *        java.lang.reflect.InvocationHandler
 *        java.beans.PropertyChangeListener
 *        java.awt.event.ActionListener
 *        javax.swing.event.ChangeListener
 */
public class FunctionalInterfaceController {

  @Test
  public void test(){
    Comparator comparator = new Comparator() {
      @Override
      public int compare(Object o1, Object o2) {
        return 0;
      }
    }
  };
}
