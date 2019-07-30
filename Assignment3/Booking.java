// Student Name: Yinsheng Dong
// Student Number: 11148648
// NSID: yid164
// Lecture Section: CMPT 270



import java.util.Scanner;
/** 
 * This is the class to record the information for a Person booking
 * a BasicFlight.  In addition to recording the Person and the BasicFlight,
 * it stores the seat, if any, that has been assigned to the Person.
 */
public class Booking 
{
	/**
	 * The Person with this Booking.
	 */
	private Person person;
	
	/**
	 * The flight for this Booking.
	 */
	private BasicFlight flight;
	
	/**
	 * The seat that has been assigned to this person, if one,
	 * or else null.
	 */
	private String seat;

	private static Scanner in;
	
	/**
	 * Initialize the Booking with the prescribed Person and flight.
	 * @param thePerson  the Person for the Booking
	 * @param theFlight  the flight for the Booking
	 */
	public Booking(Person thePerson, BasicFlight theFlight)
	{
		person = thePerson;
		flight = theFlight;
		seat = null;
	}
	
	/**
	 * gets the flight of this Booking
	 * @return  the flight of this Booking
	 */
	public BasicFlight getFlight()
	{
		return flight;
	}

	/**
	 * gets the Person of this Booking
	 * @return  the Person of this Booking
	 */
	public Person getPerson()
	{
		return person;
	}

	/**
	 * gets the seat of this Booking, which is null if it has not been set
	 * @return  the seat assigned to the person of this booking
	 */
	public String getSeat()
	{
		return seat;
	}

	/** 
	 * Assign the Person the specified seat on this flight.
	 * @param newSeat  the seat for the person
	 */
	public void setSeat(String newSeat)
	{
		seat = newSeat;
	}

	/**
	 * Gets a String representation of the Booking information
	 * @return a String representation of the information of this Booking
	 */
	public String toString()
	{
		String result = "\n" + person.getName() + " is on flight " + flight.getNumber();
		if (seat != null)
			result = result + " in seat " + seat;
		return result + "\n";
	}
	
	/**
	 * A method to test the Booking class.
	 */
	public static void main(String[] args)
	{
		in = new Scanner (System.in);
		String name, telephoneNumber,seat;
		int num, width, cap;
		System.out.println("Please enter the Passenger name: ");
		name = in.nextLine();
		System.out.println("Please enter the Passenger telephone: ");
		telephoneNumber = in.nextLine();
		System.out.println("Please enter the Passenger seat: ");
		seat = in.nextLine();
		System.out.println("Please enter the air number: ");
		num = in.nextInt();
		System.out.println("Please enter the air width: ");
		width = in.nextInt();
		System.out.println("Please enter the air cap: ");
		cap = in.nextInt();
		
		Person p = new Person(name,telephoneNumber);
		BasicFlight bf1 = new BasicFlight (num,width,cap);
		Booking b = new Booking(p,bf1);
		b.setSeat(seat);
		System.out.println(b.toString());
	}
}