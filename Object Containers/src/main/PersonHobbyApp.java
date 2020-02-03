import java.util.*;

public class PersonHobbyApp {


    public static void main(String[] args) {

        Person p1 = new Person("34561", "Paula", 32, "0723421501");
        Person p2 = new Person("36782", "Andrei", 21, "0723481902");
        Person p3 = new Person("97483", "Elena", 27, "0723451723");
        Person p4 = new Person("60894", "Daniel", 47, "0723498126");
        Person p5 = new Person("40871", "Oana", 35, "0723445678");


        Set personSet = new TreeSet(new PersonAgeComparator().reversed());

        personSet.add(p1);
        personSet.add(p2);
        personSet.add(p3);
        personSet.add(p4);
        personSet.add(p5);

        for (Object o : personSet) {
            Person person = (Person) o;
            System.out.println("Name: " + person.getName() + " Age: " + person.getAge());
        }
        System.out.println("---------------------------");


        Country ro = new Country("Romania", "40");
        Country fr = new Country("France", "41");
        Country de = new Country("Germany", "49");

        Address addressRo = new Address("Brasov", ro);
        Address addressFr = new Address("Paris", fr);
        Address addressDe = new Address("Berlin", de);

        List<Address> hobbyAddress = new ArrayList();
        hobbyAddress.add(addressRo);
        hobbyAddress.add(addressFr);
        hobbyAddress.add(addressDe);


        Hobby cycling = new Hobby("Cycling", 2, hobbyAddress.subList(hobbyAddress.indexOf(addressRo), hobbyAddress.indexOf(addressFr)));

        Hobby swimming = new Hobby("Swimming", 4, hobbyAddress);

        Hobby badminton = new Hobby("Badminton", 5, hobbyAddress);

        List<Hobby> hobby = new ArrayList();
        hobby.add(cycling);
        hobby.add(swimming);
        hobby.add(badminton);

/*       for (Hobby hobby1 : hobby) {
            System.out.println(hobby1);
                }
*/

        Map<Person, List<Hobby>> personHobby = new HashMap<>();
        personHobby.put(p1, hobby);
        personHobby.put(p2, hobby);
        personHobby.put(p3, hobby);

        getPersonHobby(personHobby, p1);
        getPersonHobby(personHobby, p2);
        // getPersonHobby(personHobby, p3);

        getPersonHobby(personHobby, p4);

    }

    /**
     * This method takes a Map and a Person object and returns a list of hobbies for the specified person.
     * @param personHobbyList Map with key a Person object and value a list of hobbies
     * @param person object
     * @return the list of hobbies for a specific person.
     */


    public static List getPersonHobby(Map<Person, List<Hobby>> personHobbyList, Person person) {

        if (personHobbyList.containsKey(person)) {

            System.out.println(person.getName() + " has the following hobbies " + personHobbyList.get(person) + "\n");

            return personHobbyList.get(person);

        }
        System.out.println(person.getName() + " has no known hobbies.");
        return null;


    }


}



