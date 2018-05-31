package domain;

import lombok.Data;

@Data
public class BeanF {
  int f;

  void init(){
    System.out.println("BeanF init");
  }

  void destroy(){
    System.out.println("BeanF destroy");
  }
}
