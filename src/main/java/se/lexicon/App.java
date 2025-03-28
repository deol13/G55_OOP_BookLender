package se.lexicon;

import se.lexicon.model.Book;
import se.lexicon.model.Person;

public class App {
    public static void main(String[] args) {
        // Initialize and display Book & Person instances
        Person person1 = new Person("Dennis", "Olsen");
        Person person2 = new Person("Johan", "Karlsson");

        Book book1 = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", person1);
        Book book2 = new Book("The Lord of the Rings: The Fellowship of the Ring", "J.R.R. Tolkien");
        Book book3 = new Book("Eragon", "Christopher Paolini");


        System.out.println("All person: ");
        System.out.println("Person one: " + person1.getPersonInformation());
        System.out.println("Person two: " + person2.getPersonInformation());

        System.out.println();

        System.out.println("All persons borrowed books: ");
        System.out.println("Person one books: " + person1.getAllBorrowedBooksInformation());
        System.out.println("Person one books: " + person2.getAllBorrowedBooksInformation());

        System.out.println();

        System.out.println("All books: ");
        System.out.println("Book one: " + book1.getBookInformation());
        System.out.println("Book two: " + book2.getBookInformation());
        System.out.println("Book three: " + book3.getBookInformation());
        System.out.println();

        // Simulate borrowing a book
        person1.loadBook(book3);
        book3.setBorrower(person1);
        person2.loadBook(book2);
        book2.setBorrower(person2);

        System.out.println("Loaned all books: ");
        System.out.println(book1.getBookInformation());
        System.out.println(book2.getBookInformation());
        System.out.println(book3.getBookInformation());
        System.out.println();

        System.out.println("All books borrowed by " + person1.getPersonInformation());
        System.out.println(person1.getAllBorrowedBooksInformation());

        // Simulate returning a book
        person1.returnBook(book1);
        person1.returnBook(book3);
        person2.returnBook(book2);

        System.out.println("Return all the books: ");
        System.out.println(book1.getBookInformation());
        System.out.println(book2.getBookInformation());
        System.out.println(book3.getBookInformation());
    }

}
