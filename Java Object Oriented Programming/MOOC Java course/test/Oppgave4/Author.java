package test.Oppgave4;

import java.util.ArrayList;
import java.util.List;

public class Author {

    private String name;
    private String email;
    private Gender gender;
    private List<Book> books = new ArrayList<Book>();

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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * @return the books
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * @param books the books to set
     */
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author[name=" + this.getName() + ",email=" + this.getEmail() + ",gender="+this.getGender()+"]"; 
    }

    public void addBook(Book book) {
        if (!this.books.contains(book)) {
            this.books.add(book);
            book.setAuthor(this);
               
        }
    }

    public int potentialIncome() {
        int sum = this.books.stream().map(c -> (c.getPrice()*c.getQuantity())).reduce(0, Integer::sum);
        return sum;
    }


}