import domain.Breed;
import domain.Horse;
import domain.Race;
import domain.Rider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.EmulationService;
import service.HorseService;
import service.RaceService;
import service.impl.EmulationServiceImpl;
import service.impl.HorseServiceImpl;
import service.impl.RaceServiceImpl;

@Configuration
public class HorseRaceConfig {

  @Bean
  public Breed breed1() {
    return Breed.builder().name("backend").build();
  }

  @Bean
  public Breed breed2() {
    return Breed.builder().name("frontend").build();
  }

  @Bean
  public Breed breed3() {
    return Breed.builder().name("fullstack").build();
  }

  @Bean
  public Horse horse1() {
    return Horse.builder().name("Danya").breed(breed1()).build();
  }

  @Bean
  public Horse horse2() {
    return Horse.builder().name("Matvey-1").breed(breed2()).build();
  }

  @Bean
  public Horse horse3() {
    return Horse.builder().name("Matvey-2").breed(breed3()).build();
  }

  @Bean
  public Horse horse4() {
    return Horse.builder().name("Vera").breed(breed3()).build();
  }

  @Bean
  public Race race() {
    return Race.builder().build();
  }

  @Bean
  public Rider rider1() {
    return Rider.builder().name("Mikha").build();
  }

  @Bean
  public Rider rider2() {
    return Rider.builder().name("Andrey D.").build();
  }

  @Bean
  public Rider rider3() {
    return Rider.builder().name("Sasha").build();
  }

  @Bean
  public Rider rider4() {
    return Rider.builder().name("Sergei l.").build();
  }

  @Bean
  public HorseService horseService() {
    return HorseServiceImpl.builder().build();
  }

  @Bean
  public RaceService raceService() {
    return RaceServiceImpl.builder().currentRace(race()).horseService(horseService()).build();
  }

  @Bean
  public EmulationService emulationService() {
    return EmulationServiceImpl.builder().race(race()).build();
  }
}
