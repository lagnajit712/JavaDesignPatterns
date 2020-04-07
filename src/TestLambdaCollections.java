import java.util.*;

public class TestLambdaCollections {
  public static void main(String[] args){
    Person person1= new Person("Name1",24);
    Person person2= new Person("Name2",34);
    Person person3= new Person("Name3",44);
    Person person4= new Person("Name4",31);
    Person person5= new Person("Name5",22);
    Person person6= new Person("Name6",54);

    City blore=new City("Bengaluru");
    City mumbai=new City("Mumbai");
    City delhi=new City("Delhi");
    City kolkata = new City("Kolkata");
    Map<City, List<Person>> map =new HashMap<>();
    map.putIfAbsent(kolkata,new ArrayList<>());
    map.get(kolkata).add(person1);
    map.computeIfAbsent(blore,p->new ArrayList<>()).add(person2);
    map.computeIfAbsent(blore,p->new ArrayList<>()).add(person3);
    System.out.println(map.get(blore));
    System.out.println(map.getOrDefault(delhi, Collections.EMPTY_LIST));

    Map<City, List<Person>> map1 =new HashMap<>();
    map1.computeIfAbsent(mumbai,p->new ArrayList<>()).add(person1);
    map1.computeIfAbsent(mumbai,p->new ArrayList<>()).add(person2);
    System.out.println(map1.get(mumbai));

    Map<City, List<Person>> map2 =new HashMap<>();
    map2.computeIfAbsent(delhi,p->new ArrayList<>()).add(person3);
    map2.computeIfAbsent(delhi,p->new ArrayList<>()).add(person4);
    map2.computeIfAbsent(delhi,p->new ArrayList<>()).add(person5);
    System.out.println(map2.get(delhi));

    map2.forEach((city,people)->{
      map1.merge(city,people,(peopleFromMap1,peopleFromMap2)->{
        peopleFromMap1.addAll(peopleFromMap2);
        return peopleFromMap1;
       });
    });
    map1.forEach((city,people)->System.out.println(city +" : "+people));

  }
}
