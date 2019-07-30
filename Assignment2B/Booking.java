// Name: Yinsheng Dong
// Student Number: 11148648
// NSID: yid164
// Lecture Section: CMPT 270

import java.util.Scanner;

/**The representation for a booking of a person on a flight, record person, flight, and seat*/
public class Booking {
	
	/**A Person class type store the person with the booking */
	private Person person; 
	/**A string field to store the flight number */
	private String flight;
	/**A String field to store the seat number*/
	private String seat;
	/**A Scanner type to store every input*/
	private static Scanner in;
	/**The constructor with the person flight and seat*/
	public Booking(Person p, String f, String s)
	{
		person = p;
		flight = f;
		seat = s;
	}
	
	/** The accessor method to return the person's info */
	public Person getPerson()
	{
		return person;
	}
	
	/**The accessor method to return the flight info*/
	public String getFlight()
	{
		return flight;
	}
	
	/**The accessor method to return the seat info */
	public String getSeat()
	{
		return seat;
	}
	
	/**The mutator method to set or change the seat number*/
	public void setSeat(String seat)
	{
		this.seat = seat;
	}
	
	/**This method print out personal info seat info and flight info those 3 methods*/
	public String toString()
	{
		String a = "Person info: "+getPerson() +" Seat info: "+getSeat() +" the Flight info: "+getFlight();
		return a;
	}
	
	
	

	public static void main(String[] args) {
		System.out.println("Please enter the person's name: ");
		in = new Scanner(System.in);
		String n = in.nextLine();
		System.out.println("Please enter the person's telephone number: ");
		String t = in.nextLine();
		/**building the new Person class for using the method*/
		Person pr = new Person(n,t);
		Person p1 = pr;
		System.out.println("Please enter the Flight number: ");
		in = new Scanner(System.in);
		String f = in.nextLine();
		System.out.println("Please enter the seat number: ");
		in = new Scanner(System.in);
		String s = in.nextLine();
		Booking b1 = new Booking(p1,f,s);
		System.out.println(b1.toString());
		/**for testing the mutator setSeat method*/
		System.out.println("Need to change the seat number? y/n"); 
		in = new Scanner(System.in);
		String a = in.nextLine();
		/**Let user to choose if or not change the seat number*/
		if (a.equals("y")||a.equals("Y"))
		{
			System.out.println("Please enter the new seat number: ");
			in = new Scanner(System.in);
			String s1 = in.nextLine();
			b1.setSeat(s1);
			/**Print out the new information*/
			System.out.println("The new info: "+b1.toString());
		}
		else
		{
			/**Print out the old info*/
			System.out.println("These datas have saved! ");
		}
		
		in.close();
		

	}

}
