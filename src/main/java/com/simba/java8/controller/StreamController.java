package com.simba.java8.controller;

import com.simba.java8.model.Person;
import com.simba.java8.service.Stream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = ("classpath:applicationContext.xml"))
@RunWith(SpringRunner.class)
@SpringBootTest
/**
 * stream操作
 *    流操作的两个基本特点
 *        1、pipelining
 *            中间操作可以返回流对象本身，类似访问者模式，多个操作串联成一个管道
 *            优点：
 *              可以做延迟执行（laziness（sleep(1000)））
 *              短路（short-circuiting）(||计算时，如果前面的值为true，则后面的运算不用考虑，被短路了)
 *        2、内部迭代
 *
 */
public class StreamController {

  @Autowired
  private Stream stream;

  @Test
  public void removalDuplicateById() {
    List<Person> personList = initPersonList();
    Person person = new Person();
    person.setId(13L);
    person.setAge(1);
    person.setName("sdfsdfasdf");
    person.setAddress("");
    personList.add(person);
    Person person1 = new Person();
    person1.setId(13L);
    person1.setAge(2);
    person1.setName("sdfsdfasdf");
    person1.setAddress("");
    personList.add(person1);
    List<Person> result = stream.removalDuplicateById(personList);
    List<Person> result1 = stream.removalDuplicateByIdandAge(personList);
//    System.out.println(result);
    System.out.println(result1);
  }

  @Test
  public void removalDuplicateByDistinct() {
    String[] strings = {"A","A","C"};
    List<String> stringList = Arrays.asList(strings);
    List<String> list = stream.removalDuplicateByDistinct(stringList);
    System.out.println(list);
  }


  @Test
  public void getSet(){
    List<Person> personList = initPersonList();
    personList.add(new Person());
    personList.add(new Person());
    Set<Person> set = stream.getSet(personList);
    System.out.println(set);
  }

  @Test
  public void getLinkList(){
    List<String> stringList =  initStringList();
    //将list转换为LinkList
    LinkedList<String> linkedList = stream.getCollection(stringList);
    linkedList.addFirst("r");
    System.out.println(linkedList);
  }

  @Test
  public void getCount(){
    List<String> stringList =  initStringList();
    Long count  = stream.getcounting(stringList);
    System.out.println(count);
  }

  @Test
  public void getAgeSum(){
    List<Person> list = initPersonList();
    int sumAge = stream.getSum(list);
    System.out.println("sumAge:"+sumAge);
  }

  @Test
  public void getAvg(){
    List<Person> list = initPersonList();
    Double avg = stream.getAvg(list);
    System.out.println("avg:"+avg);
  }

  @Test
  public void getSumri(){
    List<Person> list = initPersonList();
    IntSummaryStatistics intSummaryStatistics = stream.getSumri(list);
    System.out.println("intSummaryStatistics:"+intSummaryStatistics);
  }

  @Test
  public void getStringJoin(){
    List<Person> list = initPersonList();
    String string  = stream.getJoinString(list);
    System.out.println(string);
  }

  @Test
  public void getMax(){
    List<Person> personList = initPersonList();
    Optional<Person> optionalPerson = stream.getMax(personList);
    System.out.println(optionalPerson);
  }

  @Test
  public void getAgeCount(){
    List<Person> personList = initPersonList();
    int count = stream.reducing(personList);
    System.out.println(count);
  }

  @Test
  public void collectAndThen(){
    List<Person> personList = initPersonList();
    int count = stream.collectAndThen(personList);
    System.out.println(count);
  }

  @Test
  public void getGroup(){
    List<Person> personList = initPersonList();
    Map<String ,List<Person>> map = stream.getGroup(personList);
    System.out.println(map);
    System.out.println(map.get("person4"));
    System.out.println(map.get("person4").size());
  }

  @Test
  public void getPartition(){
    List<Person> personList = initPersonList();
    Map<Boolean,List<Person>> map  = stream.getPartition(personList);
    System.out.println(map);
  }

  /**
   * 内部迭代
   * @return
   */
  @Test
  public void innerIterator(){
    List<String> list = initStringList();
    list.stream().forEach(System.out::print);
    //parallel将当前流变为新的并行流或者创建一个新流
    System.out.println("-----------------------------");
    list.stream().parallel().forEach(System.out::print);
    //并行流（底层使用forkjoinpool，采用workStealing算法，提高效率），forkJoin在jdk1.7时被引入
    // 在大数据并行的情况下性能要高,但是并不能保证顺序
    System.out.println("-----------------------------");
    list.parallelStream().forEach(System.out::print);
    System.out.println("-----------------------------");
    //按照原来的顺序打印出来，但是会影响效率
    list.parallelStream().forEachOrdered(System.out::print);
    System.out.println("-----------------------------");
  }

  /**
   * Stream过滤
   * @return
   */
  @Test
  public void testStreamFilter(){
    List<String >list = initStringList();
    list = list.stream().filter(s->s.equals("a")).collect(Collectors.toList());
    System.out.println(list);
  }

  /**
   * Stream的map方法
   * @return
   */
  @Test
  public void testStreamMap(){
    List<String >list = initStringList();
    list = list.stream().map(s->s+"sss").collect(Collectors.toList());
    System.out.println(list);
  }


  private List<Person> initPersonList (){
    List<Person> personList = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      Person person = new Person();
      person.setId((long)i);
      person.setAge(i);
      person.setName("person"+i);
      person.setAddress("person"+i+"address");
      personList.add(person);
    }
    return personList;
  }

  private List<String> initStringList (){
    String[] strings = {"a","b","b","c","a"};
    return Arrays.asList(strings);
  }

}
