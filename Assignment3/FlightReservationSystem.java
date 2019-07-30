// Student Name: Yinsheng Dong
// Student Number: 11148648
// NSID: yid164
// Lecture Section: CMPT 270


import java.util.*;
import java.util.Scanner;
public class FlightReservationSystem {
	
	Map<String,Passenger> passengerMap;
	Map<Integer,Flight> flightMap;
	private Scanner in1;
	private Scanner in2;
	private Scanner in3;
	
	/**initialize these 2 containers
	 * @param passengerMap is for all the people known to the system
	 * @param flightMap is for all the flights known to the system*/
	public FlightReservationSystem()
	{
		passengerMap = new HashMap<String,Passenger>();
		flightMap = new HashMap<Integer,Flight>();
	}
	
	/**add a new flight to the System*/
	public void addFlight(Flight f)
	{
		flightMap.put(f.getNumber(), f);
	}
	/**add a new passenger to the system*/
	public void addPassenger(Passenger p)
	{
		passengerMap.put(p.getName(), p);
	}

	/**to book a new first-class passenger on a flight*/
	public void firstClassBooking(Passenger p, Flight f)
	{
		f.setFirstClass(p);
	}
	/** to book a passenger on a flight*/
	public void regularClassBooking(Passenger p, Flight f)
	{
		f.setRegular(p);
	}
	/**to display the empty seats of a specified flight*/
	public void emptySeat(Flight f)
	{
		System.out.println(f.emptySeat());
	}
	
	/**to assign a seat to a passenger on a flight where the passenger already has a booking*/
	public void assignSeat(String name, String seat, int index)
	{
		if(flightMap.get(index)!=null && passengerMap.get(name)!=null)
		{
			Passenger thePerson = passengerMap.get(name);
			Flight f = flightMap.get(index);
			if (thePerson.checkBooking(f))
			{
				thePerson.checkSeat(f);
				f.setRegular(thePerson);
			}
		}
	}
	/**to display all of the passengers in the system*/
	public void displayAllPassenger()
	{
		String allPassenger = " ";
		for(String key: passengerMap.keySet())
		{
			allPassenger = allPassenger+ "Name: " +passengerMap.get(key).getName()+" Telephone Number: "+ passengerMap.get(key).getTelephoneNumber()+"\n";
		}
		
		System.out.println(allPassenger);
	}
	
	
	/**to display all of the flight in the system*/
	public void displayAllFlight()
	{
		String allFlight=null;
		for(Integer key: flightMap.keySet())
		{
			allFlight = "Number: " +Integer.toString(flightMap.get(key).getNumber())+ "Width: "+ Integer.toString(flightMap.get(key).getWidth())+ " Capacity: "+Integer.toString(flightMap.get(key).getCapacity())+"\n";
			
		}
		System.out.println(allFlight);
	}
	/**the controlPannel that user can control*/
	public void controlPannel(){
		in1 = new Scanner(System.in);
		in2 = new Scanner(System.in);
		in3 = new Scanner(System.in);
		FlightReservationSystem FlightOkay = new FlightReservationSystem();
		int a;
		System.out.println("Please Enter A Number to Choose Your Options");
		a = in1.nextInt();
		if(a == 1)
		{
			System.out.println("List of all passengers");
			displayAllPassenger();
			System.out.println("List of all flights");
			displayAllFlight();
		}
		while(a!=1)
		{
			if(a == 2)
			{
			
				in1 = new Scanner(System.in);
				in2 = new Scanner(System.in);
				in3 = new Scanner(System.in);
				System.out.println("We want to get your info.   Please enter your name:");
				String name; 
				name = in1.nextLine();
				System.out.println("Please enter your telephone number:");
				String phoneNumber;
				phoneNumber = in2.nextLine();
				Passenger p1 = new Passenger(name,phoneNumber);
				FlightOkay.addPassenger(p1);
				System.out.println("Okay, Let's go to next step. ");
			}
			else if(a == 3)
			{
				in1 = new Scanner(System.in);
				in2 = new Scanner(System.in);
				in3 = new Scanner(System.in);
				System.out.println("We are going to add a new flight to the system.  ");
				System.out.println("Please enter flight number:");
				int number = in1.nextInt();
				System.out.println("Please enter flight width:");
				int width = in2.nextInt();
				System.out.println("Please enter flight capacity:");
				int capacity = in3.nextInt();
				Flight f = new Flight(number,width,capacity);
				FlightOkay.addFlight(f);
			}
			else if(a == 4)
			{
				in1 = new Scanner(System.in);
				in2 = new Scanner(System.in);
				in3 = new Scanner(System.in);
				System.out.println("Enter the flight number to see the empty seats:");
				int number = in1.nextInt();
				Flight f = FlightOkay.flightMap.get(number);
				System.out.println(f.emptySeat());
			}
			else if(a == 5)
			{
				in1 = new Scanner(System.in);
				in2 = new Scanner(System.in);
				in3 = new Scanner(System.in);
				System.out.println("We are going book a regular passenger on a flight, enter the passenger name");
				String name = in1.nextLine();
				Passenger p1 = FlightOkay.passengerMap.get(name);
				System.out.println("Please enter flight number:");
				int number = in2.nextInt();
				Flight f1 = FlightOkay.flightMap.get(number);
				FlightOkay.regularClassBooking(p1, f1);			
			}	
			else if(a == 6)
			{
				in1 = new Scanner(System.in);
				in2 = new Scanner(System.in);
				in3 = new Scanner(System.in);
				System.out.println("We are going book a first-class passenger on a flight, enter the passenger name");
				String name = in1.next();
				Passenger p1 = FlightOkay.passengerMap.get(name);
				System.out.println("Please enter flight number:");
				int i = in2.nextInt();
				Flight f1 = FlightOkay.flightMap.get(i);
				FlightOkay.firstClassBooking(p1, f1);
			}
			else if(a == 7)
			{
				in1 = new Scanner(System.in);
				in2 = new Scanner(System.in);
				in3 = new Scanner(System.in);
				System.out.println("We are going to assgin a seat to the passenger, please enter the passenger name:");
				String name = in1.next();
				System.out.println("Please enter the flight number:");
				int seat = in2.nextInt();
				System.out.println("Please enter the seat: ");
				String index = in3.next();
				FlightOkay.assignSeat(name,index,seat);
			}
			else if(a == 8)
			{
				FlightOkay.displayAllPassenger();
				
			}
			else if(a == 9)
			{
				FlightOkay.displayAllFlight();
			}
			System.out.println("Please Enter A Number to Choose Your Options");
			a = in2.nextInt();
		}
	}
	
	
	public static void main(String[] args) 
	{
		FlightReservationSystem a = new FlightReservationSystem();
		a.controlPannel();
	}

}
