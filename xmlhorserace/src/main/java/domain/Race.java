package domain;

import java.util.List;
import lombok.Data;

@Data
public class Race {
  private List<Rider> participants;
}
