// Student Name: Yinsheng Dong
// Student Number: 11148648
// NSID: yid164
// Lecture Section: CMPT 270


import java.util.*;
import java.util.Scanner;
public class Passenger extends Person {

	/** A private linked list to initialize*/
	private LinkedList<Booking> list; 
	private static Scanner in;
	
	/** initialize the super() followed by Person class
	 * @param name  to restore the person name
	 * @param number to restore the person telephoneNubmer
	 * @list to initialize the linkedList*/
	public Passenger(String name, String number) {
		super(name, number);
		list = new LinkedList<Booking>();
	}
	

	/**the method to add bookings into the Linkedlist
	 * @param return nothing*/
	public void addBooking(Booking book)
	{
		this.list.addLast(book);
	}
	
	/**@param Flight f connect to Flight class
	 * the boolean function is for checking if the passenger has a booking on the flight*/
	public boolean checkBooking(Flight f)
	{
		ListIterator<Booking> Iter = list.listIterator();
		while(Iter.hasNext())
		{
			Booking book = Iter.next();
			if(f.getNumber() ==book.getFlight().getNumber()){
			return true;	
			}
		}
		return false;
	}
	
	
	/**@param f to check the f from Flight
	 * If checkBooking function is true, then need to check the passenger has a seat reserved on the flight
	 * Return true if it does otherwise if fasle*/
	public boolean checkSeat(Flight f)
	{
		if(checkBooking(f)==true) 
		{
			ListIterator<Booking> Iter = list.listIterator();
			while(Iter.hasNext())
			{
				Booking book = Iter.next();
				if(f.getNumber() ==book.getFlight().getNumber())
				{
					if(book.getSeat()==null)
					{
						return false;
					}
					else
					{
						return true;
					}

				}
			}
			return false;
		}
		else
		{
			return false;
		}
	}
	
	/**@return a String representation of the properties of the linkedList*/
	public String toString(Booking book, Flight f)
	{
		String a = "The list of Booking: \n";
		addBooking(book);
		for (int i = 0; i<list.size(); i++)
		{
			a = a+(i+1)+" : " +list.get(i).getPerson();

		}

		return a;
	}

	
	/**
	 * A method to test the class.
	 * @param args  not used
	 */
	public static void main(String[] args) {
		String name, telephoneNumber;
		int num, width, cap;
		in = new Scanner (System.in);
		System.out.println("Please enter the air number: ");
		num = in.nextInt();
		System.out.println("Please enter the air width: ");
		width = in.nextInt();
		System.out.println("Please enter the air cap: ");
		cap = in.nextInt();
		BasicFlight bf = new BasicFlight(num,width,cap);
		Flight f = new Flight(num,width,cap);

		for(int i =0; i<cap;i++)
		{
			in = new Scanner (System.in);
			System.out.println("Please enter the Passenger name: ");
			name = in.nextLine();
			System.out.println("Please enter the Passenger telephone: ");
			telephoneNumber = in.nextLine();
			Person p =new Person(name,telephoneNumber);
			Passenger ps = new Passenger(name,telephoneNumber);
			Booking b = new Booking(p,bf);
			System.out.println(ps.toString(b,f));
		}

	}

}
