package domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Horse {
  private String name;
  private Breed breed;
}
