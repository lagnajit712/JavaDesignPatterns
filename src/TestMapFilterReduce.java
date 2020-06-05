import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestMapFilterReduce {

  public static void main(String[] args){
    List<Person> list= List.of(new Person("Name1",45),
        new Person("Name4",25),
        new Person("Name3",35),
        new Person("Name2",55));
    list.stream().map(Person::getAge).peek(System.out::println).filter(age->age>20).forEach(System.out::println);
    System.out.println("Total age "+list.stream().map(Person::getAge).reduce((v1, v2) -> v1+v2));
    System.out.println("Total age is "+list.stream().reduce(0,(partialAgeResult,p2)->partialAgeResult + p2.getAge(), Integer::sum));

  }
}
