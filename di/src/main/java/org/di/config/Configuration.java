package org.di.config;

import org.di.reflection.Reflections;


public interface Configuration {
  <T> Class<? extends T> getImplClass(Class<T> ifc);

  Reflections getScanner();
}
