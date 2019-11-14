package com.simba.java8.controller;

import com.simba.java8.model.TestModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.lang3.ArrayUtils;

public class TestController {
  private static Log logger = LogFactory.getLog(TestController.class);


  public static void main(String[] agrs){
    Integer[] number = {};
    List<Integer> list = Arrays.asList(number);
//    List<Integer> list = new ArrayList<>();
    TestModel<Integer> testModel = new TestModel<Integer>();
    testModel.setList(Arrays.asList(number));

    Predicate<Integer> predicate1= i-> i>2 ;
    Predicate<Integer> predicate2= i-> i%2 == 0 ;
    Predicate<Integer> predicate= predicate1.and(predicate2);
    testModel.setTestFilter(predicate);
    List<Integer> fList = list.stream().filter(predicate).collect(Collectors.toList());

    testModel.setList(
        testModel.getList().stream().filter(testModel.getTestFilter()).collect(Collectors.toList()));
    logger.info("list:"+list.toString());
    logger.info(fList.toString());
    logger.info(testModel.toString());

    Predicate<String> ps = x -> x.equals("");

    logger.info(ArrayUtils.contains(number,9));
  }

  //custom filter
  public static <T> List<T> customFilter(List<T> lists,Predicate<T> predicate){
    return lists.stream().filter(predicate).collect(Collectors.toList());
  }

  //获取list中的类的某个字段
  public String getFiled(){
    List<TestModel> testModelList = new ArrayList<>();
    String testModelName = testModelList.stream()
        .map(testModel->testModel.getTestName())
        .collect(Collectors.joining(","));
    return testModelName;
  }
}
