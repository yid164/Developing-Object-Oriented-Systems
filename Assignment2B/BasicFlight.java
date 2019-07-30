// Name: Yinsheng Dong
// Student Number: 11148648
// NSID: yid164
// Lecture Section: CMPT 270


import java.util.Scanner; 
/**The class BasicFlight to store the bookings for the people who have a spot on the flight*/
public class BasicFlight {
	/**a field to store the integer number of the flight*/
	private int number;
	/**a integer field to store the width of the plane*/
	private int width;
	/**a integer field to store the capacity of the plane*/
	private int capacity;
	/**a string array to store the booking for this flight*/
	private String []bookings;
	/** a scanner field to store every input from user*/
	private static Scanner in;
	
	
	/**The constructor with parameters for the number, width and total capacity of the flight*/
	public BasicFlight(int n, int w, int c)
	{
		number = n;
		width = w;
		capacity = c;
		bookings = new String[c];
	}
	
	
	/**The accessor methods to return the number of the flight*/
	public int getNumber()
	{
		return number;
	}
	
	
	/** The accessor methods to return the width of the flight*/
	public int getWidth()
	{
		return width;
	}
	
	
	/**The accessor methods to return the capacity of the plane*/
	public int getCapacity()
	{
		return capacity;
	}
	
	
	/**The mutator method to store the booking in a seat of the flight, which one parameter from Booking class*/
	public void setSeat(Booking b1,String seat)
	{
		this.bookings[indexFromSeat(seat)] = b1.toString();

	}
	
	
	/**The accessor method with a string parameter to return the person who booked the seat,which one parameter from Booking class*/
	public String getPerson(String seat, Booking b1)
	{ 
		String p = bookings[indexFromSeat(seat)];
		bookings[indexFromSeat(seat)]=b1.toString();
		
		return p;
		
	}
	
	/**The accessor method boolean value to determine whether the seat is booked or not*/
	public boolean isSeatAvailable(String seat)
	{
		if (bookings[indexFromSeat(seat)] ==null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**The accessor method that convert index seat number to the string seat number*/
	public int indexFromSeat(String seat)
	{
		int index;
		int seatLength = seat.length()-1;
		char c = seat.charAt(seat.length()-1);
		int col = (int)c -65;
		String rowString = seat.substring(0, seatLength);
		int rowInteger = Integer.parseInt(rowString);
		index = (rowInteger-1)*width+col;
		return index;
	}

	/**The accessor method that convert string seat number to a index seat number*/
	public String seatFromindex(int index)
	{
		String seatNo;
		int rowNumber = (index/width)+1;
		char colChar = (char)((index%width)+65);
		seatNo = ""+rowNumber+colChar;
		return seatNo;
	}
	
	/**the method to return flight number, capacity and width, and print out every seat in the plane which are booked or empty, which one parameter from Booking class*/
	public String toString(Booking b1,String seat){
		String a = "The number of flight: "+getNumber()+" The Flight Width: "+getWidth()+" The Flight Capacity: "+getCapacity();
		for(int i=0; i<capacity; i++)
		{ 
			System.out.println(seatFromindex(i));
			if (isSeatAvailable(seat)==true)
			{
				System.out.println("EMPTY");

			}
			else
			{
				 System.out.println(bookings[i]);;
			}
		}
		return a;
	}
	
	/**Test all methods work*/
	public static void main(String[] args) {
		System.out.println("Please enter the number of flight: ");
		in = new Scanner(System.in);
		int a = in.nextInt();
		System.out.println("Please enter the width: ");
		int b = in.nextInt();
		System.out.println("Please enter the capacity: ");
		int c = in.nextInt();
		BasicFlight bf1 = new BasicFlight(a,b,c);
		System.out.println("Please enter the person name: ");
		in = new Scanner(System.in);
		String name =in.nextLine();
		System.out.println("Please enter the person's telephone number: ");
		String telephone = in.nextLine();
		Person n1 = new Person(name,telephone);
		System.out.println("Please enter the Flight number: ");
		String f1 = in.nextLine();
		System.out.println("Please enter the seat number: ");
		String s1 = in.nextLine();
		Booking b1 = new Booking(n1,f1,s1);
		/**test setSeat method*/
		bf1.setSeat(b1,s1);
		/**Test to String method*/
		bf1.toString(b1,s1);
		/**Test indexFromSeat method*/
		System.out.println("The index converted by the seat: "+bf1.indexFromSeat(s1));
		
		/**Add another person to test isSeatAvailable method*/
		System.out.println("Would you like add a new person? y/n");
		in=new Scanner(System.in);
		String o = in.nextLine();
		if (o.equals("y")||o.equals("Y"))
		{
			/**To input another's information and put the same seat number to test the method works or not*/
			System.out.println("Please enter the new name: ");
			in=new Scanner(System.in);
			String name1 = in.nextLine();
			System.out.println("Please enter the new person's telephone number: ");
			String telephone1 = in.nextLine();
			Person n2 = new Person(name1,telephone1);
			System.out.println("Please enter the new person's seat number: ");
			String s2 = in.nextLine();
			String f2 = f1;
			if(bf1.isSeatAvailable(s2)==true)
			{
				System.out.println("The seat is available\n");
				Booking b2 = new Booking(n2,f2,s2);
				bf1.setSeat(b2,s2);
				bf1.toString(b2,s2);
			}
			else
			{
				/**if the isSeatAvailable method works, it should put out like this, and also can get a test to try the getPerson method*/
				System.out.println("Sorry, the seat has booked by" +bf1.getPerson(s2,b1));
			}
		}
		
		/**To test the seatFromindex method by input a new index to convert a seat number*/
		System.out.println("Please enter a integer index to convert to the seat number" );
		in = new Scanner(System.in);
		int idx = in.nextInt();
		System.out.println(bf1.seatFromindex(idx));
		
		
		in.close();
			

	}

}
