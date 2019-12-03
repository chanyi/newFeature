package com.simba.java8.controller;

import com.simba.java8.model.EmptyPerson;
import com.simba.java8.model.FunctionalInterfaceClass;
import com.simba.java8.model.FunctionalInterfaceModel;
import com.simba.java8.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.junit.Test;

/**
 * 方法引用
 *  使用::+方法名的方式，实现对方法的调用
 *    四种调用方式：
 *      1、构造器的引用
 *      2、静态方法的引用
 *      3、特定类的任意对象的引用
 *      4、特定对象的引用
 */
public class MethodRefrenceController {

  /**
   * 构造器的引用
   */
  @Test
  public void testConstructRef(){
    Person person = getPerson(Person::new);
    System.out.println(person);
  }
  /**
   * 静态方法的引用
   */
  @Test
  public void testStaticMethodRef(){
    List<Person> list = getPerson(Person::new);
    //list中的对象的类型和方法的参数的类型需要是一样的
    list.forEach(Person::staticMethod);

    List<String> stringList = new ArrayList<>();
    stringList.forEach(Person::staticMethodString);
  }

  /**
   * 特定对象引用
   */
  @Test
  public void testObjectRef(){
    List<Person> list = new ArrayList<>();
    Person person = new Person();
    //specialObject方法接受的是一个person对象，而且这个对象不可以在方法体内部被修改
    list.forEach(person::specialObject);
  }

  /**
   * 特定的类引用
   */
  @Test
  public void testClassRef(){
    List<Person> list = new ArrayList<>();
    list.forEach(Person::specialClass);
  }

  /**
   *获取一个person对象
   * @param supplier  上限是EmptyPerson
   * @return
   */
  public  <T> T getPerson(Supplier<? super EmptyPerson> supplier){
    return (T)supplier.get();
  }

}
