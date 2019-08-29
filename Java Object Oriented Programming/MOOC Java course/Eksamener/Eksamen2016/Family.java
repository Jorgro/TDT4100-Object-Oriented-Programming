package Eksamener.Eksamen2016;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Family {

    List<Person> family = new ArrayList<>();

    /**
     * Adds a Person as a new family member
     * 
     * @param person the Person to add
     */
    public void addMember(Person person) {
        if (!(this.family.contains(person))) {
            this.family.add(person);
        }
    }

    /**
     * Finds a member with the given name
     * 
     * @param name
     * @return the Person in this Family with the provided name
     */

    public Person findMember(String name) {
        try {
            return this.family.stream().filter(c -> c.getName().equals(name)).findFirst().get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        Family f = new Family();
        Person j = new Person("Jude");
        f.addMember(j);
        System.out.println(f.findMember("de"));
    }

    /**
     * Writes the contents of this Family to the OutputStream, so it can be
     * reconstructed using load.
     * 
     * @param out
     */
    public void save(OutputStream out) throws IOException {
        PrintWriter pw = new PrintWriter(out);
        for (Person p : this.family) {
            pw.print(p.getGender());
            pw.print(" ");
            pw.print("\"" + p.getName() + "\"");
            pw.println();
        }

        pw.println();
        for (Person p : this.family) {
            if (p.iterator().hasNext()) {
                pw.print("\"" + p.getName() + "\"");
                for (Person child : p) {
                    pw.print(" \"" + p.getName() + "\"");
                }
            }
            pw.println();
        }

        pw.flush();
    }

    /**
     * Helper method that splits a line into a list of tokens, either words or
     * quoted names (quotes are removed).
     * 
     * @param line – the string to tokenize
     */

    private static List<String> tokenize(String line) {
        return null;
    }

    /**
     * Loads contents from the provided InputStream into this Family.
     * 
     * @param in
     */
    public void load(InputStream in) throws IOException {
        Scanner sc = new Scanner(in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            List<String> tokens = tokenize(line);
            Gender g = Gender.valueOf(tokens.get(0));
            if (g != null) {
                Person p = new Person(tokens.get(1));
                p.setGender(g);
                addMember(p);
            } else {
                Person p = findMember(tokens.get(0));
                for (int i = 1; i < tokens.size(); i++) {

                    Person child = findMember(tokens.get(i));
                    p.addChild(child);
                }
            }

        }
        sc.close();
    }

}