package org.di.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class DeprecatedHandlerProxyConfigurator implements ProxyConfigurator {
  @Override
  public Object replaceWithProxyIfNeeded(Object t, Class implClass) {
    if (implClass.isAnnotationPresent(Deprecated.class)) {
      return Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(),
        (proxy, method, args) -> getInvocationHandlerLogic(method, args, t));
    } else {
      return t;
    }

  }

  private Object getInvocationHandlerLogic(Method method, Object[] args, Object t) {
    System.out.println("********** что ж ты делаешь урод!! ");
    try {
      return method.invoke(t, args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      throw new RuntimeException("Unable to run invocation handler");
    }
  }
}
