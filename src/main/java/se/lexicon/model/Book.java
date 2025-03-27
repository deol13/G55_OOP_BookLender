package se.lexicon.model;


import java.util.UUID;

/**
 * This class represents a Book model with properties and methods
 * to manage book-related information and operations.
 */
public class Book {

    // Fields

    private String id;
    private final String title;
    private final String author;
    private boolean available;

    private Person borrower;

    // Constructors

    public Book(String title, String author) {
        this(title, author, null);
        this.id = UUID.randomUUID().toString();
    }

    public Book(String title, String author, Person borrower) {
        if (title == null || title.isEmpty()) throw new IllegalArgumentException("Title can't be null or empty");
        else this.title = title;
        if (author == null || author.isEmpty()) throw new IllegalArgumentException("Author can't be null or empty");
        else this.author = author;
        setBorrower(borrower);
        this.id = UUID.randomUUID().toString();
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public Person getBorrower() {
        return borrower;
    }

    public void setBorrower(Person borrower) {
        this.borrower = borrower;
        available = borrower == null;
    }

    // Methods

    public String getBookInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id)
                .append(", title: ").append(title)
                .append(", author: ").append(author)
                .append(", available: ").append(available);
        if(borrower != null ) sb.append(", borrower: ").append(borrower.getPersonInformation());
        return sb.toString();
    }
}