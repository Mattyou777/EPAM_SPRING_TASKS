package domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Rider {
  private String name;
  private Horse horse;

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Rider ").append(name);
    if (horse != null) {
      stringBuilder.append(", horse ").append(horse.getName()).append(", breed ").append(horse.getBreed().getName());
    }
    return stringBuilder.toString();
  }
}
