package org.di;

import org.di.config.JavaConfiguration;
import org.di.factory.ObjectFactory;

import java.util.Map;


public class Application {
  public static ApplicationContext run(String[] packagesToScan, Map<Class, Class> ifc2ImplClass) {
    JavaConfiguration config = new JavaConfiguration(packagesToScan, ifc2ImplClass);
    ApplicationContext context = new ApplicationContext(config);
    ObjectFactory objectFactory = new ObjectFactory(context);
    context.setFactory(objectFactory);

    return context;
  }

  public static ApplicationContext run(String[] packagesToScan) {
    JavaConfiguration config = new JavaConfiguration(packagesToScan);
    ApplicationContext context = new ApplicationContext(config);
    ObjectFactory objectFactory = new ObjectFactory(context);
    context.setFactory(objectFactory);

    return context;
  }
}
