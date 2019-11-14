package com.simba.java8.service.impl;

import com.simba.java8.model.Person;
import com.simba.java8.service.Stream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import net.bytebuddy.dynamic.scaffold.MethodGraph.Linked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StreamImpl implements Stream {

  @Override
  public <T, E> List<T> removalDuplicate(List<E> list) {
    return null;
  }

  ///////////////////////////collect 操作////////////////////////////

  @Override
  public Set<Person> getSet(List<Person> list) {
    Set<Person> result = list.stream().collect(Collectors.toSet());
    //相当于这个
//    HashSet<Person> hashSet = new HashSet<>(list);
    return result;
  }

  @Override
  public LinkedList<String> getCollection(List<String> list) {
    LinkedList<String> result = list.stream().collect(Collectors.toCollection(LinkedList::new) );
    //相当于这个
//    LinkedList<String> linkedList = new LinkedList<>(list);
    return result;
  }

  @Override
  public Long getcounting(List<String> list) {
    Long count = list.stream().collect(Collectors.counting());
    //相当于下面两个
    Long counts = list.stream().count();
    int counts1 = list.size();
    return count;
  }


  @Override
  public int getSum(List<Person> list) {
    int sum = list.stream().collect(Collectors.summingInt(Person::getAge));
    //相当于
    int sum1 = list.stream().mapToInt(Person::getAge).sum();
    //相当于
    int sum2 = list.stream().map(Person::getAge).reduce(Integer::sum).get();
    return sum;
  }

  @Override
  public Double getAvg(List<Person> list) {
    Double avg = list.stream().collect(Collectors.averagingInt(Person::getAge));
    return avg;
  }

  /**
   * 获取流中的对象的统计值（个数，最大最小，平均数）
   * @param list
   * @return
   */
  @Override
  public IntSummaryStatistics getSumri(List<Person> list) {
    IntSummaryStatistics intSummaryStatistics = list.stream().collect(Collectors.summarizingInt(Person::getAge));
    return intSummaryStatistics;
  }

  @Override
  public String getJoinString(List<Person> list){
    String string = list.stream().map(Person::getAddress).collect(Collectors.joining(","));
    return string;
  }

  /**
   * 选出某元素最大的对象
   * maxBy minBy同理
   * @param list
   * @return
   */
  @Override
  public Optional<Person> getMax(List<Person> list){
    Optional<Person> optionalPerson = list.stream().collect(Collectors.maxBy(Comparator.comparingInt(Person::getAge)));
    //相当于下面
    //Optional<Person> person1 = list.stream().max(Comparator.comparingInt(Person::getAge));
    return optionalPerson;
  }
  /**
   * 规约操作
   * @param list
   * @return
   */
  @Override
  public int reducing(List<Person> list){
    int ageCount = list.stream().collect(Collectors.reducing(0,Person::getAge,(i,j)->i+j));
    return ageCount;
  }

  @Override
  public int collectAndThen(List<Person> list){
    int ageCount = list.stream().collect(Collectors.collectingAndThen(Collectors.toList(),List::size));
    return ageCount;
  }

  @Override
  public Map<String,List<Person>> getGroup(List<Person> list){
    Map<String,List<Person>> map = list.stream().collect(Collectors.groupingBy(Person::getName));
    return map;
  }

  /**
   * 按照某个属性 将对象分为两类
   * @param list
   * @return
   */
  @Override
  public Map<Boolean,List<Person>> getPartition(List<Person> list){
    Map<Boolean,List<Person>> map = list.stream().collect(Collectors.partitioningBy(person -> person.getAge()>3));
    return map;
  }





  /**
   * 按照用户id去重
   * @param list
   * @return
   */
  @Override
  public List<Person> removalDuplicateById(List<Person> list) {
    List<Person> result = list.stream().collect(
        Collectors.collectingAndThen(
            Collectors.toCollection(
                ()->new TreeSet<>(Comparator.comparing(Person::getId))),
            ArrayList::new));
    return result;
  }

  /**
   * 按照用户id和age去重
   * @param list
   * @return
   */
  @Override
  public List<Person> removalDuplicateByIdandAge(List<Person> list) {
    List<Person> result = list.stream().collect(
        Collectors.collectingAndThen(
            Collectors.toCollection(
                ()->new TreeSet<>(Comparator.comparing(person->person.getId()+person.getAge()))),
            ArrayList::new));
    return result;
  }

  @Override
  public <T> List<T> removalDuplicateByDistinct(List<T> list){
    List<T> result = list.stream().distinct().collect(Collectors.toList());
    return result;
  }

}
