package domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorPrinter implements BeanPostProcessor {

  public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
    if(o instanceof BeanF){
      System.out.println("postProcessBeforeInitialization: " + s);
    }
    return o;
  }

  public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
    if(o instanceof BeanF){
      System.out.println("postProcessAfterInitialization: " + s);
    }
    return o;
  }
}
