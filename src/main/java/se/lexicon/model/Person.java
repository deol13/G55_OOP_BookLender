package se.lexicon.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class represents a Person model with properties and methods
 * to manage personal details and interactions with the library system.
 */
public class Person {
    // Fields

    private static int sequencer = 0;
    private final int id;
    private String firstName;
    private String lastName;

    private List<Book> books;

    // Constructors

    public Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
        id = getNextId();
        books = new ArrayList<Book>();
    }

    // Getters and setters

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.isEmpty()) throw new IllegalArgumentException("First name can't be null or empty");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.isEmpty()) throw new IllegalArgumentException("Last name can't be null or empty");
        this.lastName = lastName;
    }

    // Methods

    private static int getNextId() {
        return ++sequencer;
    }

    // Load/return methods only changes books list to lower the interaction between Book and Person.
    // Personally I think its bettet to have a separate method in another class that handles both Book and Person object
    // so Person and Book stays separate and focus on themselves.
    public void loadBook(Book book) {
        if(book.isAvailable())
            books.add(book);
    }

    public void returnBook(Book book) {
        if(book.getBorrower() == this)
            books.remove(book);
    }

    public String getPersonInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id)
                .append(", Name: ").append(firstName)
                .append(" ").append(lastName);

        return sb.toString();
    }

    public String getAllBorrowedBooksInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append("Books borrowed: \n");
        for (Book book : books)
            sb.append("book: ").append(book.getBookInformation()).append("\n");
        return sb.toString();
    }
}