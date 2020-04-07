import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class TestSpliterator {

  public static void main(String[] args){
    try(
      Stream<String> s= Stream.of(Files.lines(Paths.get("flightdata1.csv"))).flatMap(p->p)){
        Spliterator<String> lineSpliterators=s.spliterator();
        Spliterator<Flight>flightSpliterator=new FlightSpliterator(lineSpliterators);
        Stream<Flight> flight= StreamSupport.stream(flightSpliterator,false);
        flight.forEach(System.out::println);
       } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
