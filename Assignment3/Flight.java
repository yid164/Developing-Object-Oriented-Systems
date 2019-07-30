// Student Name: Yinsheng Dong
// Student Number: 11148648
// NSID: yid164
// Lecture Section: CMPT 270

import java.util.*;
public class Flight extends BasicFlight{
	private LinkedList<Booking> noSeatList;
	private static Scanner input;
	
	/** initialize the super() followed by BasicFlight class
	 *  initialize the LinkedList */
	public Flight(int flightNumber, int flightWidth, int flightCapacity){
		super(flightNumber, flightWidth, flightCapacity);
		noSeatList = new LinkedList<Booking>();
	}

	

	/**to store the regular book data to the linked list
	 * @param return nothing*/
	
	public void setRegular(Passenger p1)
	{
		Booking regularBook = new Booking(p1,this);
		p1.addBooking(regularBook);
		noSeatList.add(regularBook);
		
	}
	
	/**to store the first-class book data to the list
	 * @return nothing*/
	public void setFirstClass(Passenger p1)
	{
		FirstClassBooking firstClass = new FirstClassBooking(p1,this);
		p1.addBooking(firstClass);
		
	}
	
	/**to determine if the seat need to set or not
	 * @return false if the seat if null
	 * @return true and automaticlly set the set and remove the data from the list*/
	public boolean setASeat (Booking book)
	{
		if (book.getSeat()==null)
		{
			return false;
		}
		else
		{

			this.setSeat(book);
			this.noSeatList.remove(book);
			return true;
		}
	}

	/**
	 * @return the integer number that seat left*/
	public int seatRemain()
	{
		int i = this.getCapacity()-this.noSeatList.size();;
		return i;
	}

	/**@return the empty seat that can be assigned */
	public String emptySeat()
	{
		String a = "EMPTY SEATS: ";
		for(int i=0; i<this.getCapacity();i++)
		{
			if(this.isSeatAvailable(this.seatFromIndex(i)))
			{
				a = a+"\n"+this.seatFromIndex(i)+"\n";
			}
			else
			{
				a = a+"  ";
			}
		}
		return a;
	}
	
	
	
	/**test every function that I wrote*/
	public String toString(Passenger p, Booking book)
	{
		String a = "Let's do some test: \n";
		String c = null;
		c = "The seats remain: "+seatRemain()+"\n" + emptySeat();
		if(setASeat(book))
		{
			setFirstClass(p);
		}
		else
		{
			setRegular(p);
		}
		

		return a+c;
	}

	
	
	public static void main(String[] args)
	{
		String name, telephoneNumber;
		int num, width, cap;
		input = new Scanner (System.in);
		System.out.println("Please enter the air number: ");
		num = input.nextInt();
		System.out.println("Please enter the air width: ");
		width = input.nextInt();
		System.out.println("Please enter the air cap: ");
		cap = input.nextInt();
		BasicFlight bf = new BasicFlight(num,width,cap);
		Flight f = new Flight(num,width,cap);
		for(int i =0; i<cap;i++)
		{
			input = new Scanner (System.in);
			System.out.println("Please enter the Passenger name: ");
			name = input.nextLine();
			System.out.println("Please enter the Passenger telephone: ");
			telephoneNumber = input.nextLine();
			Person p1 = new Person(name,telephoneNumber);
			Passenger p = new Passenger(name,telephoneNumber);
			Booking book = new Booking(p1,bf);
			System.out.println(f.toString(p,book));
		}

	}	
			

}
