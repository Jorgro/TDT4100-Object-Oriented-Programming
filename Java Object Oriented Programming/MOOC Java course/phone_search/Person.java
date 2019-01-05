package phone_search;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Person {
    private String name;
    private Set<String> phoneNumbers;
    private List<String> addresses;

    public Person(String name) {
        this.setName(name);
        this.phoneNumbers = new HashSet<String>();
        this.addresses = new ArrayList<String>();
    }

    /**
     * @return the addresses
     */
    public String getAddresses() {
        if (this.addresses.size() == 0) {
            return "unkown";
        }
        String addresses = "";
        for (int i = 0; i < this.addresses.size(); i++) {
            if (i == this.addresses.size() -1) {
                addresses += this.addresses.get(i);
            } else {
                addresses += this.addresses.get(i) + ", ";
            }
        }
        
        return addresses;
    }

    /**
     * @param addresses the addresses to set
     */
    public void addAddress(String address) {
        this.addresses.add(address);
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

    @Override
    public String toString() {

        String person = this.name + "\n address: " + this.getAddresses() + "\n";


        if (this.phoneNumbers.size() > 0) {
            if (this.phoneNumbers.size() >1 ) {
                person += " phone numbers:\n  ";
            } else if (this.phoneNumbers.size() == 1){
                person += " phone number:\n  ";
            }
            for (String number : this.phoneNumbers) {
                person += number + "\n  ";
            }
        } else {
            person += " phone number unknown";
        }

        return person.strip();
    }



}