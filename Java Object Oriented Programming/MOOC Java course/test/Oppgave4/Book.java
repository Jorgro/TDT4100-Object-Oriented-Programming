package test.Oppgave4;

public class Book {
    private String name;
    private int price;
    private int quantity;
    private Author author;





    public Book(String name, Author author, int price) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.quantity = 1;
    }

    public Book(String name, Author author, int price, int qty) {
        this(name, author, price);
        this.quantity = qty;
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
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(Author author) {
        this.author = author;
        if (!this.author.getBooks().contains(this)) {
            this.author.getBooks().add(this);
        }
     //uendelig rekursjon? (stackoverflow)
    }

    @Override
    public String toString() {
        return "Book[name="+this.getName() + "," + this.author.toString()+ ",price=" + this.price + ",qty=" + this.quantity + "]";
    }

    public static void main(String[] args) {
        Author a = new Author();
        a.setGender(Gender.FEMALE);
        Book bok = new Book("helo", a, 2);
        Book b = new Book("hello", a, 200);
        a.addBook(bok);
        a.addBook(b);
        System.out.println(b);
        System.out.println(a.getBooks());
        System.out.println(a.potentialIncome());
    }
}