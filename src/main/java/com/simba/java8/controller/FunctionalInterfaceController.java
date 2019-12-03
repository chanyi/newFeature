package com.simba.java8.controller;

import com.simba.java8.model.FunctionalInterfaceModel;
import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.junit.Test;

/**
 * 函数式接口
 *    有且仅有一个抽象方法，但可以有多非抽象方法(默认方法和静态方法，都有实现体)
 *     1.8前的抽象方法
 *        java.lang.Runnable
 *        java.util.concurrent.Callable
 *        java.security.PrivilegedAction
 *        java.util.Comparator(comparator中有两个抽象方法，compare和equal方法，
 *                             但是equal方法被Object类实现，所以在计算抽象方法的时候，不计算入内。
 *                             所以comparator也是函数式接口)
 *        java.io.FileFilter
 *        java.nio.file.PathMatcher
 *        java.lang.reflect.InvocationHandler
 *        java.beans.PropertyChangeListener
 *        java.awt.event.ActionListener
 *        javax.swing.event.ChangeListener
 *    1.8后的抽象方法
 *        java.util.function
 *          包含多个类
 *          四个常用的函数式接口，Function,Predicate,Supplier,Consumer
 */
public class FunctionalInterfaceController {

  /**
   *  计算
   * 接受一个参数，返回一个结果（什么类型都可以）
   */
  @Test
  public void testFunction(){
    Function<String ,String > function = new Function<String, String>() {
      @Override
      public String apply(String s) {
        return  s+"---";
      }
    };
    Function<String,String> function1 = s1->{return s1+"+++";};

    String result = getFunction(function,"hello");
    System.out.println(result);

    String result1 = getFunction(function1,"hello");
    System.out.println(result1);

    Function<String,String> function2 = s1->{return s1+"===";};

    String result2 = getFunctionAndThen(function1,function2,"hello");
    System.out.println(result2);

  }

  /**
   * 预测
   * 接受一个结果，返回一个boolean类型结果
   */

  @Test
  public void testPredicate(){
    Predicate<String> predicate = s -> {
      if(s.contains("www")){
        return true;
      }else{
        return false;
      }
    };
    Predicate<String> predicate2 = s -> {
      if(s.contains("sss")){
        return true;
      }else{
        return false;
      }
    };

    boolean flag = getPredicate(predicate,predicate2,"wwwssswwwddd");
    System.out.println(flag);

  }

  /**
   * 提供
   * 不传参数，返回一个结果
   */
  @Test
  public void testSupplier(){
    Supplier<String> supplier = ()->{return "ss";};

    String ss = getSupplier(supplier);
    System.out.println(ss);
  }

  /**
   *  消费
   * 传入一个参数，不返回
   */
  @Test
  public void testConsumer(){
    Consumer consumer = (t)->{
      System.out.println(t);
    };
    Consumer consumer2 = (t)->{
      System.out.println(t);
    };
    getConsumer(consumer,"222");
    getConsumerAfter(consumer,consumer2,"333");
  }

  private <V,T> T getFunction(Function<V,T> function,V a){
    return function.apply(a);
  }

  private <V,T> T getFunctionAndThen(Function<T,V> function,Function<V,T> function2,T a){
    return function.andThen(function2).apply(a);
  }

  private <T> boolean getPredicate(Predicate<T> predicate,Predicate<T> predicate2,T t){
    return predicate.and(predicate2).test(t);
  }

  private <T> T getSupplier(Supplier<T> supplier){
    return supplier.get();
  }
  private <T> void getConsumer(Consumer<T> consumer,T t){
    consumer.accept(t);
  }

  private <T> void getConsumerAfter(Consumer<T> consumer,Consumer<T> consumer2,T t){
    consumer.andThen(consumer2).accept(t);
  }
}
