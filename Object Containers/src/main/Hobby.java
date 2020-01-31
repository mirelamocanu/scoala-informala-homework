import java.util.List;
import java.util.Objects;

public class Hobby {

    private String nameOfHobby;
    private Integer frequency;

    List<Address> hobbyAddress;


    public Hobby(String nameOfHobby, Integer frequency, List<Address> hobbyAddress1) {
      this();
        this.nameOfHobby = nameOfHobby;
        this.frequency = frequency;
        this.hobbyAddress = hobbyAddress1;
    }
    public Hobby() {

    }


    @Override
    public String toString() {
        return
                nameOfHobby + '\'' +
                        ", hobbyAddress=" + hobbyAddress +
                        '}' +
                        "\n"
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hobby hobby = (Hobby) o;
        return Objects.equals(nameOfHobby, hobby.nameOfHobby) &&
                Objects.equals(frequency, hobby.frequency) &&
                Objects.equals(hobbyAddress, hobby.hobbyAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfHobby, frequency, hobbyAddress);
    }

    public String getNameOfHobby() {
        return nameOfHobby;
    }

    public void setNameOfHobby(String nameOfHobby) {
        this.nameOfHobby = nameOfHobby;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public List<Address> getHobbyAddress() {
        return hobbyAddress;
    }

    public void setHobbyAddress(List<Address> hobbyAddress) {
        this.hobbyAddress = hobbyAddress;
    }
}
