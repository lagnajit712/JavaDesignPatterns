import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestFlatMap {
  public static void main(String[] args){
    Stream<String> s1=Stream.of("One");
    Stream<String> s2=Stream.of("Two");
    Stream<String> s3=Stream.of("Three");
    Comparator<Flight> compareByPrice=Comparator.comparing(Flight::getPrice);
    Stream<Stream<String>> stream=Stream.of(s1,s2,s3);
    Stream<String> flatMapStream= stream.flatMap(Function.identity());
    flatMapStream.forEach(System.out::println);
    try{
      Stream<String> s= Stream.of(Files.lines(Paths.get("flightdata1.csv")),
          Files.lines(Paths.get("flightdata2.csv")),
          Files.lines(Paths.get("flightdata3.csv"))).flatMap(Function.identity());
      s.map(line->{
        String split[]=line.split(",");
        return  new Flight(Integer.parseInt(split[0]),split[1],Double.parseDouble(split[2]),split[3],split[4]);
      }).sorted(compareByPrice).collect(Collectors.toList()).forEach(System.out::println);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
