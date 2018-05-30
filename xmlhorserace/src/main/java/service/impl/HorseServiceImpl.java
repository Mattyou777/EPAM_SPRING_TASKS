package service.impl;

import domain.Horse;
import domain.Rider;
import service.HorseService;

public class HorseServiceImpl implements HorseService {

  @Override
  public void buyHorse(Rider rider, Horse horse) {
    rider.setHorse(horse);
  }
}
