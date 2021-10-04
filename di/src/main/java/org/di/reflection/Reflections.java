package org.di.reflection;


import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

public class Reflections {
  private final Set<Class<?>> classes;

  public Reflections(String[] packagesToScan) {
    this.classes = new HashSet<>();

    for (String packageToScan : packagesToScan) {
      this.classes.addAll(Scanner.findAllClasses(packageToScan));
    }
  }

  public <T> Set<Class<? extends T>> getSubTypesOf(Class<T> type) {
    return classes.parallelStream()
      .filter(type::isAssignableFrom)
      .filter(aClass -> !aClass.isInterface())
      .map(aClass -> (Class<? extends T>) aClass)
      .collect(toSet());
  }
}
