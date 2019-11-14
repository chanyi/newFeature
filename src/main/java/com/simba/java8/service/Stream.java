package com.simba.java8.service;

import com.simba.java8.model.Person;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface Stream {

  Set<Person> getSet(List<Person> list);

  LinkedList<String> getCollection(List<String> list);

  Long getcounting(List<String> list);

  int getSum(List<Person> list);

  Double getAvg(List<Person> list);

  IntSummaryStatistics getSumri(List<Person> list);

  String getJoinString(List<Person> list);

  Optional<Person> getMax(List<Person> list);

  int reducing(List<Person> list);

  Map<Boolean,List<Person>> getPartition(List<Person> list);

  int collectAndThen(List<Person> list);

  Map<String,List<Person>> getGroup(List<Person> list);

  <T,E> List<T> removalDuplicate(List<E> list);

  List<Person> removalDuplicateById(List<Person> list);

  List<Person> removalDuplicateByIdandAge(List<Person> list);

  <T> List<T> removalDuplicateByDistinct(List<T> list);

}
