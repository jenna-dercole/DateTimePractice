package practice;

/**
 * This class represents a real-world person. 
 * 
 * @author Jenna, jennardercole@gmail.com
 * @version 1.00
 */
public class Person {
    private String firstName;
    private String lastName;
    
    /** default constructor */
     
    public Person() {}
    
    /**
     * Convenience constructor for quickly creating and initializing 
     * an object.
     * s
     * @param firstName - not validated
     * @param lastName  - not validated
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * Gets the last name
     * @return the last name of the person
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Set the last name of the person
     * @param lastName - not validated 
     */ 
    public void setLastName(String lastName) throws IllegalArgumentException {
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            this.lastName = lastName;
        }
    }
    
    
}
