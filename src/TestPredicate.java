import java.util.function.Predicate;

public class TestPredicate {
  public static void main(String[] args){
    Predicate<String> p1= s->s.length()<20;
    Predicate<String>  p2= s->s.length()>5;
    System.out.println("hello is shorter than 20 chars "+p1.test("Hello"));
    Predicate<String>  p3=p1.and(p2);
    System.out.println("Validates p3 "+p3.test("khglergeruguierigerioerg"));
    Predicate<String>  p4=p1.or(p2);
    System.out.println("Validates p4 "+p4.test("dsfdsk"));
    Predicate<String>  p5=Predicate.isEqual("Java");
    System.out.println("Validates p5 "+p5.test("Java"));
    MyPredicate<String>  p6=MyPredicate.isEqualsTo("Java");
  }
}
