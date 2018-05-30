package service.impl;

import domain.Horse;
import domain.Race;
import domain.Rider;
import java.util.Collections;
import java.util.List;
import lombok.Data;
import service.HorseService;
import service.RaceService;

@Data
public class RaceServiceImpl implements RaceService {

  private Race currentRace;
  private HorseService horseService;

  @Override
  public Race getRace(List<Rider> riders, List<Horse> horses) {
    List<Rider> randomRiders = null;
    Collections.copy(riders,randomRiders);
    Collections.shuffle(randomRiders);

    List<Horse> randomHorses = null;
    Collections.copy(horses,randomHorses);
    Collections.shuffle(randomHorses);

    for (int i = 0; i < 2; i++){
      horseService.buyHorse(randomRiders.get(i), randomHorses.get(i));
      System.out.println(i + randomRiders.get(i).toString());
    }

    currentRace.setParticipants(randomRiders);
    return currentRace;
  }
}
