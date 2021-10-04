package org.di.factory;

import org.di.annotation.InjectProperty;
import org.di.ApplicationContext;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;


public class InjectPropertyAnnotationObjectConfigurator implements ObjectConfigurator {

  private final Map<String, String> propertiesMap;

  public InjectPropertyAnnotationObjectConfigurator() {
    String path = Objects.requireNonNull(
      ClassLoader.getSystemClassLoader().getResource("application.properties")
    ).getPath();

    Stream<String> lines;

    try {
      lines = new BufferedReader(new FileReader(path)).lines();
    } catch (FileNotFoundException e) {
      throw new RuntimeException("Error with reading properties file");
    }

    propertiesMap = lines.map(line -> line.split("=")).collect(toMap(arr -> arr[0], arr -> arr[1]));

  }

  @Override
  public void configure(Object t, ApplicationContext context) {
    Class<?> implClass = t.getClass();
    for (Field field : implClass.getDeclaredFields()) {
      InjectProperty annotation = field.getAnnotation(InjectProperty.class);
      if (annotation != null) {
        String value = annotation.value().isEmpty() ? propertiesMap.get(field.getName()) : propertiesMap.get(annotation.value());
        field.setAccessible(true);
        try {
          field.set(t, value);
        } catch (IllegalAccessException e) {
          throw new RuntimeException("Error with configuring class");
        }
      }
    }
  }
}
