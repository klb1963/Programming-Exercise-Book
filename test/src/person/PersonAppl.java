package person;

public class PersonAppl {
    public static void main(String[] args) {

    Person person = new Person(15, "Peter");

    person.setName("Alex");
    person.setAge(25);

        System.out.println(person.getAge());
        System.out.println(person.getName());
    }
}
