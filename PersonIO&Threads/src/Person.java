public class Person {

    private String name;
    private String birthDate;
    private PersonGender gender;

    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", gender=" + gender +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        String[] nameArr = name.split(" ");
        return nameArr[0];
    }

    public String getBirthDate() {
        return birthDate;
    }

    public PersonGender getGender() {
        return gender;
    }


    public void setGender(String stringGender) {

        if (stringGender.equalsIgnoreCase(String.valueOf(PersonGender.FEMALE))) {
            this.gender = PersonGender.FEMALE;
        } else if (stringGender.equalsIgnoreCase(String.valueOf(PersonGender.MALE))) {
            this.gender = PersonGender.MALE;

        } else if (Integer.parseInt(stringGender) == PersonGender.MALE.getGenderCode()) {
            this.gender = PersonGender.MALE;
        } else if (Integer.parseInt(stringGender) == PersonGender.FEMALE.getGenderCode()) {
            this.gender = PersonGender.FEMALE;
        } else
            throw new IllegalArgumentException("Invalid gender");

    }
}
