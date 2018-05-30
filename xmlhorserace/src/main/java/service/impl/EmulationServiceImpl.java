package service.impl;

import domain.Race;
import domain.Rider;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class EmulationServiceImpl implements service.EmulationService {

  private Race race;
  private Rider betRider;

  public EmulationServiceImpl(Race race) {
    this.race = race;
  }

  @Override
  public void startRace() {
    System.out.println("Ready... Steady... Go!");
    Rider winner = null;

    for(int i = 1; i < 3; i++) {
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Results of the " + i + " circle:");
      winner = printCurrentState();
    }

    System.out.println(winner.equals(betRider) ?
        "Take your prize, lucky bastard!" : "Your horse loose =(");
  }

  @Override
  public void putMoneyOn() {
    System.out.print("Choose the horse: ");

    Scanner in = new Scanner(System.in);
    int id = in.nextInt();

    betRider = race.getParticipants().get(--id);
    System.out.println("Good luck, " + betRider.getName() + "!");
  }

  private Rider printCurrentState(){
    List<Rider> riderList = race.getParticipants();
    Collections.shuffle(riderList);
    for (Rider rider : riderList) {
      System.out.println(rider);
    }
    return riderList.get(0);
  }
}
