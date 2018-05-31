package service.impl;

import domain.Horse;
import domain.Race;
import domain.Rider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;
import service.HorseService;
import service.RaceService;

@Data
@Service
@Builder
public class RaceServiceImpl implements RaceService {

  private Race currentRace;
  private HorseService horseService;

  @Override
  public Race getRace(List<Rider> riders, List<Horse> horses) {
    Collections.shuffle(riders);

    Collections.shuffle(horses);

    List<Rider> participantsRiders = new ArrayList<>();

    for (int i = 1; i < 3; i++){
      participantsRiders.add(riders.get(i-1));
      horseService.buyHorse(riders.get(i-1), horses.get(i-1));
      System.out.println(i + " " + participantsRiders.get(i-1).toString());
    }

    currentRace.setParticipants(participantsRiders);
    return currentRace;
  }
}
