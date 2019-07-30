// Student Name: Yinsheng Dong
// Student Number: 11148648
// NSID: yid164
// Lecture Section: CMPT 270



import java.util.Scanner;

/**
 * A basic flight class with a unique number, a capacity, seats to store 
 * Bookings of passengers, and a width that specifies the number of seats per row.
 */
public class BasicFlight 
{
	/** 
	 * The unique number of this flight.
	 */
	private int number;
	
	/**
	 * The number of seats in a row of the flight.
	 */
	private int width;
	
	/**
	 * The container to store the Bookings on this flight.  A Booking is placed
	 * in the array location corresponding to the seat of the Person.
	 */
	private Booking[] seats;

	private static Scanner in;
	
	/**
	 * Initialize the flight with the specified number, width and capacity.
	 * @param flightNumber    the unique number of the flight
	 * @param flightWidth     the number of seats in a row
	 * @param flightCapacity  the total number of seats on the flight
	 */
	public BasicFlight(int flightNumber, int flightWidth, int flightCapacity)
	{
		number = flightNumber;
		width = flightWidth;
		seats = new Booking[flightCapacity];
		
				
	}
	
	/**
	 * gets the flight number of this flight
	 * @return  the unique number of this flight
	 */
	public int getNumber()
	{
		return number;
	}
	
	/**
	 * gets the number of seats in a row
	 * @return  the number of seats in a row
	 */
	public int getWidth()
	{
		return width;
	}
	
	/**
	 * gets the number of seats on the flight
	 * @return  the number of seats on the flight
	 */
	public int getCapacity()
	{
		return seats.length;
	}
	
	/**
	 * Place the booking in the container according the seat specified in the booking,
	 * as long as the seat of the parameterized Booking is set.
	 * @param theBooking  the booking to be placed in the container, given its seat has been set
	 */
	public void setSeat(Booking theBooking)
	{
		if (theBooking.getSeat() == null)
			throw new RuntimeException("Cannot add a booking to a flight "
										+ "when its seat isn't set.");
		seats[indexFromSeat(theBooking.getSeat())] = theBooking;
	}
	
	/**
	 * Gets the Person at a specific seat of the flight
	 * @param seat  a seat of the flight that has been booked by a Person
	 * @return  the Person with the booking in the specified seat 	
	 */
	public Person getPerson(String seat)
	{
		return seats[indexFromSeat(seat)].getPerson();
	}
	
	/**
	 * Decides if the seat is valid and available
	 * @return is the specified seat valid and available?
	 */
	public boolean isSeatAvailable(String seat)
	{
		int index = 0;
		try
		{
			index = indexFromSeat(seat);
		} catch (Exception e)
		{
			return false;
		}
		if (index < 0 || index >= seats.length)
			return false;
		else
			return seats[index] == null;

	}
	
	/**
	 * @param seat  a specified seat on the flight
	 * @return      the array location that corresponds to the seat, 
	 */ 
	public int indexFromSeat(String seat)
	{
		char rowPosition = seat.charAt(seat.length()-1);
		int positionIndex = rowPosition - 'A';  // index of position in row
		int rowNum = Integer.parseInt(seat.substring(0, seat.length()-1));
		return (rowNum - 1)*width + positionIndex; 
	}
	
	/**
	 * @param i   a specified location in the array
	 * @return    the seat that corresponds to the index
	 */
	public String seatFromIndex(int i)
	{
		int positionIndex = i%width;  // index of position in row
		int rowNum = i/width + 1;
		char rowPosition = (char)('A' + positionIndex);
		return "" + rowNum + rowPosition;
	}
	
	/**
	 * @return a String representation of the properties of the flight
	 */
	public String toString()
	{
		String result = "\nFlight " + number + " with capacity " + seats.length
						+ " and width " + width + " has passengers: ";
		for (int i = 0; i < seats.length; i++)
		{
			result = result + "\nseat " + seatFromIndex(i) + ": ";
			if (seats[i] != null)
				result = result + seats[i].getPerson().getName();
		}
		return result + "\n";
	}
	
	/**
	 * A method to test the class.
	 * @param args  not used
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
		BasicFlight bf = new BasicFlight(num,width,cap);
		Booking b = new Booking(p ,bf);
		b.setSeat(seat);
		bf.setSeat(b);
		System.out.println(bf.toString());
	}
}