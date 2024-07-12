package students_dekanat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Objects;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String birthDay;
    private String course;
    private int numGroup;
    private String country;
    private String gender;

    public Student(int id, String firstName, String lastName, String birthDay, String course, int numGroup, String country, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.course = course;
        this.numGroup = numGroup;
        this.country = country;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getNumGroup() {
        return numGroup;
    }

    public void setNumGroup(int numGroup) {
        this.numGroup = numGroup;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", course='" + course + '\'' +
                ", numGroup=" + numGroup +
                ", country='" + country + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    //Comparator for Sorting by Birthday
    public static Comparator<Student> birthdComparator = (s1, s2) -> {
        //creation of DateTimeFormatter OBJECT that can parse dates in the format dd.MM.yyyy (day, month, year).
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        // now we parse the birtDay (which should be a String) of the 1st and 2nd Student (s1, s2) into a LocalDate object
        // using the formatter.
        LocalDate birthD1 = LocalDate.parse(s1.getBirthDay(), formatter);
        LocalDate birthD2 = LocalDate.parse(s2.getBirthDay(), formatter);
        return birthD1.compareTo(birthD2);
    };

    //now we want to calculate the age of the Student in years
    public double getAge() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birthD = LocalDate.parse(birthDay, formatter);
        //This line gets the current date as a LocalDate object
        // Эта строка получает текущую дату в виде объекта LocalDate
        LocalDate currentDate = LocalDate.now();
        //Calculation the number of years between birthDate and currentDate
        long years = ChronoUnit.YEARS.between(birthD, currentDate);
        //This line returns the calculated age as an integer
        return(int) years;
    }
}
