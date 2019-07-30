import java.util.Scanner;

/**
 * The model of a person who has a name and a telephone number, where the telephone number can be
 * changed but not the name.
 */
public class Person {
    /**
     * The name of the person.
     */
    private String personName;

    /**
     * The telephone number of the Person.
     */
    private String telephoneNumber;

	private static Scanner in;

    /**
     * Initialize an instance with the given name and telephone number.
     * 
     * @param name the name for the Person
     * @param number the telephone number for the Person
     */
    public Person(String name, String number) {
        personName = name;
        telephoneNumber = number;
    }

    /**
     * gets the name of the Person
     * @return the name of the Person
     */
    public String getName() {
        return personName;
    }

    /**
     * gets the telephone number
     * @return the telephone number of the Person
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * Change the telephone number of the person.
     * 
     * @param newNumber the new telephone number for the Person
     */
    public void setTelephoneNumber(String newNumber) {
        telephoneNumber = newNumber;
    }

    /**
     * creates a String representation
     * @return a String representation of the person
     */
    public String toString() {
        return "\nName: " + personName + "   Telephone number: " + telephoneNumber
                + "\n";
    }

    /**
     * A method to test the Person class.
     */
    public static void main(String[] args) {
    	String name, telephonenumber;
    	in = new Scanner(System.in);
    	System.out.println("Please enter the Passenger name: ");
    	name = in.nextLine();
    	System.out.println("Please enter the telephone number: ");
    	telephonenumber = in.nextLine();
    	Person p = new Person(name,telephonenumber);
    	System.out.println(p.toString());
    	
    }
}
