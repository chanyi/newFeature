package com.simba.model;

import java.util.List;
import java.util.function.Predicate;

public class TestModel<T> {
  private List<Integer> list;

  private Predicate<T> testFilter;

  public List<Integer> getList() {
    return list;
  }

  public void setList(List<Integer> list) {
    this.list = list;
  }

  public Predicate<T> getTestFilter() {
    return testFilter;
  }

  public void setTestFilter(Predicate<T> testFilter) {
    this.testFilter = testFilter;
  }

  @Override
  public String toString() {
    return "TestModel{" +
        "list=" + list +
        ", testFilter=" + testFilter +
        '}';
  }
}
