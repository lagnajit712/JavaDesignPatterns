@FunctionalInterface
public interface MyPredicate<T> {
  boolean test(T t1);
  static <U> MyPredicate<U> isEqualsTo(U u){
    return s->s.equals(u);
  }

}
