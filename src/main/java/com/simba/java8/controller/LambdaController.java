package com.simba.java8.controller;


import com.simba.java8.service.Stream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 *  java8最新引入lambda表达式
 *
 *  注意：lambda表达式引用的变量只能是用final修饰的变量
 */
public class LambdaController {

  @Test
  public void compareString(){
    String a = "ab";
    String b = "aaa";
    int flag = a.compareTo(b);
    System.out.println(flag);
  }

  @Test
  public void showsort(){
    String[] testArr = {"aa","bb","ee","rr","cc"};
    List<String> testList = Arrays.asList(testArr);
    List<String> testList2 = Arrays.asList(testArr);
    Collections.sort(testList, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o1.compareTo(o2);
      }
    });
    System.out.println(testList);
    Collections.sort(testList2,(o1,o2)->{return  o1.compareTo(o2);});
    System.out.println(testList2);
  }

}
