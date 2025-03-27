package se.lexicon.model;

/**
 * This class represents a Person model with properties and methods
 * to manage personal details and interactions with the library system.
 */
public class Person {
    // Fields

    private static int sequencer = 0;
    private int id;
    private String firstName;
    private String lastName;

    // Constructors

    public Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
        id = getNextId();
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.isEmpty()) throw new IllegalArgumentException("First name can't be null or empty");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.isEmpty()) throw new IllegalArgumentException("Last name can't be null or empty");
        this.lastName = lastName;
    }

    // Methods

    public static int getNextId() {
        return ++sequencer;
    }

    public void loadBook(Book book) {
        if(book.isAvailable())
            book.setBorrower(this);
    }

    public void returnBook(Book book) {
        if(book.getBorrower() == this)
            book.setBorrower(null);
    }

    public String getPersonInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id)
                .append(", Name: ").append(firstName)
                .append(" ").append(lastName);
        return sb.toString();
    }
}