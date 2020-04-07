import java.util.Spliterator;
import java.util.function.Consumer;

public class FlightSpliterator implements Spliterator<Flight> {
  private Spliterator<String> spliterator;

  public FlightSpliterator(Spliterator<String> lineSpliterators) {
    this.spliterator=lineSpliterators;
  }

  @Override public boolean tryAdvance(Consumer<? super Flight> action) {
    return this.spliterator.tryAdvance(line->{
      String split[]=line.split(",");
      Flight flight= new Flight(Integer.parseInt(split[0]),split[1],Double.parseDouble(split[2]),split[3],split[4]);
      action.accept(flight);
    });
  }

  @Override public Spliterator<Flight> trySplit() {
    return null;
  }

  @Override public long estimateSize() {
    return spliterator.estimateSize()/3;
  }

  @Override public int characteristics() {
    return spliterator.characteristics();
  }

  public Spliterator<String> getSpliterator() {
    return spliterator;
  }

  public void setSpliterator(Spliterator<String> spliterator) {
    this.spliterator = spliterator;
  }
}
