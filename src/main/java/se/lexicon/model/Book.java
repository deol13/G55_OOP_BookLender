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
    }

    public Book(String title, String author, Person borrower) {
        if (title == null || title.isEmpty()) throw new IllegalArgumentException("Title can't be null or empty");
        else this.title = title;
        if (author == null || author.isEmpty()) throw new IllegalArgumentException("Author can't be null or empty");
        else this.author = author;

        // I personally don't like this, I would not allow Person to be sent in here, instead I would just have load/return methods
        available = true;
        if(borrower != null) {
            borrower.loadBook(this);
            setBorrower(borrower);
        }
        else setBorrower(borrower);

        this.id = UUID.randomUUID().toString();
    }

    // Getters and setters

    public boolean isAvailable() {
        return available;
    }

    public Person getBorrower() {
        return borrower;
    }

    // I think its cleaner to have load/return methods that does the checks and then a separate set borrow method.
    // This way I can use setBorrow at any time inside this class and its much clearer what the user wants to do with separate load/return methods.
    private void setBorrower(Person borrower) {
        this.borrower = borrower;
        available = borrower == null;
    }

    // Methods

    public boolean loadThisBook(Person borrower){
        if(available) {
            setBorrower(borrower);
            return true;
        }
        return false;
    }

    public void returnThisBook(){
        if(!available)
            setBorrower(null);
    }

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