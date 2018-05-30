package domain;

import java.util.List;
import lombok.Data;

@Data
public class Race {
  private Long id;
  private List<Riders> participants;
}
