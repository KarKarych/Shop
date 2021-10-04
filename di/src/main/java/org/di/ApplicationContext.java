package org.di;

import org.di.annotation.Singleton;
import org.di.config.Configuration;
import org.di.factory.ObjectFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ApplicationContext {
  private final Map<Class, Object> cache = new ConcurrentHashMap<>();

  private final Configuration configuration;

  private ObjectFactory factory;

  public ApplicationContext(Configuration configuration) {
    this.configuration = configuration;
  }

  public <T> T getObject(Class<T> type) {
    if (cache.containsKey(type)) {
      return (T) cache.get(type);
    }

    Class<? extends T> implClass = type;

    if (type.isInterface()) {
      implClass = configuration.getImplClass(type);
    }
    T t = factory.createObject(implClass);

    if (implClass.isAnnotationPresent(Singleton.class)) {
      cache.put(type, t);
    }

    return t;
  }

  public Configuration getConfig() {
    return configuration;
  }

  public void setFactory(ObjectFactory factory) {
    this.factory = factory;
  }
}
