package org.di.config;

import org.di.reflection.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class JavaConfiguration implements Configuration {
  private final Reflections scanner;
  private final Map<Class, Class> ifc2ImplClass;

  public JavaConfiguration(String[] packagesToScan, Map<Class, Class> ifc2ImplClass) {
    this.ifc2ImplClass = ifc2ImplClass;
    this.scanner = new Reflections(packagesToScan);
  }

  public JavaConfiguration(String[] packagesToScan) {
    this.ifc2ImplClass = new HashMap<>();
    this.scanner = new Reflections(packagesToScan);
  }

  @Override
  public <T> Class<? extends T> getImplClass(Class<T> ifc) {
    return ifc2ImplClass.computeIfAbsent(ifc, aClass -> {
      Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc);
      if (classes.size() != 1) {
        throw new RuntimeException(ifc + " has 0 or more than one impl. Please update your config");
      }

      return classes.iterator().next();
    });

  }

  @Override
  public Reflections getScanner() {
    return scanner;
  }
}












