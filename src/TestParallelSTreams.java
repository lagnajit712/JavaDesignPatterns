import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestParallelSTreams {
  public static void main(String[] args){
    System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","2");
    List<String> strings=new CopyOnWriteArrayList<>();
    Stream.iterate("+",s->s+"+").parallel().limit(20)
        .peek(s->System.out.println(s+" proocesed in the thread "
            +Thread.currentThread().getName())).forEach(s->strings.add(s));
    System.out.println("String size "+strings.size());
    Stream.of(0,2,4,6,8,9,10,12).dropWhile(n->n % 2==0).forEach(System.out::println);

    Stream<Integer> stream
        = Stream.of(5, 6, 7, 8, 9, 10);

    // apply takeWhile to take all the numbers
    // matches passed predicate
    List<Integer> list
        = stream.dropWhile(number -> (number / 4 == 1))
        .collect(Collectors.toList());

    // print list
    System.out.println(list);

    Stream<String> stream1
        = Stream.of("aman", "amar", "suraj",
        "suvam", "akshay","Zahafuj");

    // apply takeWhile to take all the names
    // matches passed predicate
    List<String> list1
        = stream1.dropWhile(name -> (name.charAt(0) == 'a'))
        .collect(Collectors.toList());

    // print list
    System.out.println(list1);
  }
}
