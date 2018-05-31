import domain.Horse;
import domain.Race;
import domain.Rider;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.EmulationService;
import service.RaceService;

public class HorseRaceApp {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(HorseRaceConfig.class);

    Rider rider1 = context.getBean("rider1", Rider.class);
    Rider rider2 = context.getBean("rider2", Rider.class);
    Rider rider3 = context.getBean("rider3", Rider.class);
    Rider rider4 = context.getBean("rider4", Rider.class);
    ArrayList<Rider> ridersList = Stream.of(rider1, rider2, rider3, rider4)
        .collect(Collectors.toCollection(ArrayList::new));

    Horse horse1 = context.getBean("horse1", Horse.class);
    Horse horse2 = context.getBean("horse2", Horse.class);
    Horse horse3 = context.getBean("horse3", Horse.class);
    Horse horse4 = context.getBean("horse4", Horse.class);
    ArrayList<Horse> horsesList = Stream.of(horse1, horse2, horse3, horse4)
        .collect(Collectors.toCollection(ArrayList::new));

    RaceService raceService= context.getBean("raceService", RaceService.class);

    System.out.println("Race participants:");
    Race race = raceService.getRace(ridersList,horsesList);

    EmulationService emulator = context.getBean("emulationService", EmulationService.class);
    emulator.putMoneyOn();
    emulator.startRace();
  }

  }
