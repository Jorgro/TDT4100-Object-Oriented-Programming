package Eksamener.Eksamen2011;

import java.util.Date;
import java.util.Random;

public class Person {

    private Date birthday;
    private final Gender gender;
    private String personNumber;

    public Person(Date birthday, Gender gender) {
        this.birthday = birthday;
        this.gender = gender;
    }

    public int getDay() {
        return this.birthday.getDate();
    }

    public Gender getGender() {
        return this.gender;
    }

    public Date getDateOfBirth() {
        return birthday;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.birthday = dateOfBirth;
    }

    public void setPersonNumber() {
        String s = Integer.toString(this.birthday.getDate()) + Integer.toString(this.birthday.getMonth());

        int i = this.birthday.getYear();

        String k = Integer.toString(i > 100 ? i - 100 : i);
        this.personNumber = s + k;
        Random random = new Random();
        this.personNumber += Integer.toString(random.nextInt(10)) + Integer.toString(random.nextInt(10));
        int n = 2 * random.nextInt(5);
        this.personNumber += (this.gender == Gender.FEMALE ? n : n + 1);

        int[] F = { 3, 7, 6, 1, 8, 9, 4, 5, 2 };
        int[] G = { 5, 4, 3, 2, 7, 6, 5, 4, 3, 2 };

        this.personNumber += multiply(this.personNumber, F);
        this.personNumber += multiply(this.personNumber, G);

    }

    public String multiply(String number, int[] array) {

        int k = 0;
        for (int i = 0; i < array.length; i++) {
            k += Integer.parseInt(number.substring(i, i + 1)) * array[i];

        }
        return Integer.toString(11 - k % 11);
    }

}