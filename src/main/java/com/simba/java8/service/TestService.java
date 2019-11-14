package com.simba.java8.service;

import java.util.function.Predicate;
import org.springframework.stereotype.Service;

@Service
@FunctionalInterface
public interface TestService extends Predicate<Integer > {
  @Override
  boolean test(Integer integer);
}
