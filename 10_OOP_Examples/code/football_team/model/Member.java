package football_team.model;

public class Member {
    String name;
    int number;
    int age;

    public Member(String name, int age, int number) {
        this.name = name;
        this.age = age;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public final boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Member member)) return false;

        return number == member.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Member{");
        sb.append("name='").append(name).append('\'');
        sb.append(", number=").append(number);
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
