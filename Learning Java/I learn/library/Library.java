package library;

import java.util.ArrayList;

public class Library {
	
	private ArrayList<Book> Books;
	
	public Library() {
		this.Books = new ArrayList<Book>();
	}
	
	public void addBook(Book book) {
		this.Books.add(book);
	}
	
	public void printBooks() {
		for (Book book : this.Books) {
			System.out.println(book);
			
		}
	}
	public ArrayList<Book> searchByTitle(String title) {
		ArrayList<Book> Books = new ArrayList<Book>();
		
		for (Book book : this.Books) {
			if (StringUtils.included(book.title(), title)) {
				Books.add(book);
			}
		}
		return Books;
		
	}
	
	public ArrayList<Book> searchByPublisher(String publisher) {
		ArrayList<Book> Books = new ArrayList<Book>();
		
		for (Book book : this.Books) {
			if (StringUtils.included(book.publisher(), publisher)) {
				Books.add(book);
			}
		}
		return Books;
		
	}
	
	public ArrayList<Book> searchByYear(int year) {
		ArrayList<Book> Books = new ArrayList<Book>();
		
		for (Book book : this.Books) {
			if (book.year() == year) {
				Books.add(book);
			}
		}
		return Books;
		
	}
	

}
