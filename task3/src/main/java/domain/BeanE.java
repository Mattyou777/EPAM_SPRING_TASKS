package domain;

import lombok.Data;

@Data
public class BeanE {
  int e;
  public void printer(){
    System.out.println("BeanE id: " + e);
  }
}
