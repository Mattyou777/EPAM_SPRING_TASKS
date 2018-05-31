package service;

import domain.Horse;
import domain.Race;
import domain.Rider;
import java.util.List;

public interface RaceService {

  Race getRace(List<Rider> riders, List<Horse> horses);

}
