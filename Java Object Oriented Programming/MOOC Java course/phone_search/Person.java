package phone_search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Person {
    private String name;
    private String address;
    private Set<String> phoneNumbers;

    public Person(String name) {
        this.setName(name);
        this.phoneNumbers = new HashSet<String>();
        this.address = null;
    }

    public void addNumber(String number) {
        this.phoneNumbers.add(number);
    } 



    /**
     * @return the phoneNumber
     */
    public Set<String> getPhoneNumbers() {
        return this.phoneNumbers;
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }


}