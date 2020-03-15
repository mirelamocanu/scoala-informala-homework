public enum PersonGender {
    MALE(0),
    FEMALE(1);

    private final int genderCode;

    PersonGender(int gender) {
        this.genderCode = gender;
    }

    public int getGenderCode() {
        return this.genderCode;
    }


}
