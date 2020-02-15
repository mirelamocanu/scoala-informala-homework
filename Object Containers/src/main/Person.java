import java.util.Objects;

public class Person {

    private String CNP;
    private String name;
    private Integer age;
    private String telephone;

    public Person(String CNP, String name, Integer age, String telephone) {
        this.CNP = CNP;
        this.name = name;
        this.age = age;
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(getCNP(), person.getCNP());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCNP());
    }


    @Override
    public String toString() {
        return "Person{" +
                "CNP='" + CNP + '\'' +
                ", name='" + name + '\'' +
                ", varsta=" + age +
                ", telephone='" + telephone + '\'' +
                '}';
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
