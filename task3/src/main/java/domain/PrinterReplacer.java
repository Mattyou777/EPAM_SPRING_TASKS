package domain;

import java.lang.reflect.Method;
import org.springframework.beans.factory.support.MethodReplacer;

public class PrinterReplacer implements MethodReplacer {

  public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {

    System.out.println("BeanE method printer has been replaced");

    return null;
  }
}
