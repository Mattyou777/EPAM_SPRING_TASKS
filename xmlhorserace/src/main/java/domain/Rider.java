package domain;

import lombok.Data;

@Data
public class Rider {
  private String name;
  private Horse horse;

  @Override
  public String toString() {
    return "Rider " + name  +
        ", horse " + horse.getName() + ", breed " + horse.getBreed().getName();
  }
}
