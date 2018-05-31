package domain;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Race {
  private List<Rider> participants;
}
