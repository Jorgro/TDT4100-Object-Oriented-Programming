package phone_search;

import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class UserInterface {
    private Scanner reader;
    private Register register;

    public UserInterface() {
        this.reader = new Scanner(System.in);
        this.register = new Register();
    }
    public void start() {
        String menu = "phone search\n"
        + "available operations:\n"
        + "1 add a number\n"
        + "2 search for a number\n"
        + "3 search for a person by phone number\n"
        + "4 add an address\n"
        + "5 search for personal information\n"
        + "6 delete personal information\n"
        + "7 filtered listing\n"
        + "x quit";

        System.out.println(menu);

        while(true) {
            System.out.print("command: ");
            String userInput = this.reader.nextLine();
            if (userInput.equals("1")) {
                this.command1();
            } else if (userInput.equals("2")) {
                this.command2();
            } else if (userInput.equals("3")) {
                this.command3();
            } else if (userInput.equals("4")) {
                this.command4();
            } else if (userInput.equals("5")) {
                this.command5();
            } else if (userInput.equals("6")) {
                this.command6();
            } else if (userInput.equals("7")) {
                this.command7();
            } else if (userInput.equals("x")) {
                break;
            } else {
                System.out.println("Invalid userinput");
            }

        }

    }

    private void command1() {
        System.out.print("whose number: ");
        String name = this.reader.nextLine();
        System.out.print("number: ");
        String number = this.reader.nextLine();

        this.register.addNumber(name, number);
    }  
    
    private void command2() {
        System.out.print("whose number: ");
        String name = this.reader.nextLine();

        Set<String> numbers = this.register.searchPersonNumbers(name);
        if (numbers != null) {
            for (String number : numbers) {
                System.out.println(number);
            }
        } else {
            System.out.println("not found");
        }
    }

    private void command3() {
        System.out.print("number: ");
        String numberComparison = this.reader.nextLine();
        String namePerson = this.register.searchByNumber(numberComparison);

        if (namePerson != null) {
            System.out.println(namePerson);
        } else {
            System.out.println("not found");
        }
    }

    private void command4() {
        System.out.print("whose address: ");
        String name = reader.nextLine();
        System.out.print("street: ");
        String street = reader.nextLine();
        System.out.print("city: ");
        String city = reader.nextLine();

        this.register.addAddress(name, street, city);
    }

    private void command5() {
        System.out.print("whose information: ");
        String name = reader.nextLine();

        Person person = this.register.searchPerson(name);
        if (person != null) {

             System.out.println("address " + person.getAddresses());

            Set<String> numbers = this.register.searchPersonNumbers(name);
            if (numbers.size() > 0) {
                if (numbers.size() >1 ) {
                    System.out.println("phone numbers:");
                } else {
                    System.out.println("phone number: ");
                }
                for (String number : numbers) {
                    System.out.println(number);
                } 
            } else {
                System.out.println("phone number unknown");
            } 
        } else {
            System.out.println("not found");
        }

    }

    public void command6() {
        System.out.print("whose information: ");
        String name = this.reader.nextLine();

        this.register.remove(name);
    }

    public void command7() {
        System.out.println("keyword (if empty, all listed): ");
        String keyword = reader.nextLine();
        List<Person> filteredSearch = this.register.filteredSearch(keyword);

        for (Person person : filteredSearch) {
            System.out.println(person);
        }
    }


    


    public static void main(String[] args) {
        UserInterface hey = new UserInterface();

        hey.start();
    }
}