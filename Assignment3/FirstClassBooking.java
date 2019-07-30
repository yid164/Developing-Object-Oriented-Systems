// Student Name: Yinsheng Dong
// Student Number: 11148648
// NSID: yid164
// Lecture Section: CMPT 270



import java.util.Scanner;
public class FirstClassBooking extends Booking {
	
	private String mealPlan;
	private static Scanner in;
	private Scanner in2;

	/** initialize the super() followed by Booking class
	 * @param thePerson  to Person
	 * @param theFlight to restore BasicFlight information
	 * @initialize the mealplan is null*/
	public FirstClassBooking(Person thePerson, BasicFlight theFlight) {
		super(thePerson, theFlight);
		mealPlan = null;

		// TODO Auto-generated constructor stub
	}
	

	/** To set a meal meal plan from null to the newMealPlan
	 * @param return the newMealPlan*/
	public void setMealPlan(String newMealPlan)
	{
		this.mealPlan = newMealPlan;
	}


	/**
	 * Gets the String at a meal plan
	 * @param no
	 * @return  the mealPlan 	
	 */
	
	public String getMealPlan()
	{
		return mealPlan;
	}
	
	
	/**
	 * to distinguit  a first-class booking from a regular booking  by meal plan
	 * return true if be a first-class passenger
	 */ 
	public boolean FirstOrRegular()
	{
		System.out.println("Do you want to become First Class Passenger? ");
		in2 = new Scanner(System.in);
		String choice = in2.nextLine();
		if(choice.equals("Y")||choice.equals("y"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	/**
	 * test all of above those function, to make sure everything works
	 */ 
	public String toString()
	{
		String a = "This is the Booking for you: \n";
		if (FirstOrRegular()==true)
		{
			System.out.print("Please enter your meal plan");
			in = new Scanner(System.in);
			String meal = null;
			meal = in.nextLine();
			setMealPlan(meal);
			a = a + "First-Class Passenger: \n" +super.toString()+" "+getMealPlan();
		}
		else
		{
			a = a + "Regular-Class Passenger: \n" +super.toString();
		}
		return a;
	}
	

	public static void main(String[] args) {
		in = new Scanner (System.in);
		String name, telephoneNumber;
		int num, width, cap;
		System.out.println("Please enter the air number: ");
		num = in.nextInt();
		System.out.println("Please enter the air width: ");
		width = in.nextInt();
		System.out.println("Please enter the air cap: ");
		cap = in.nextInt();
		BasicFlight bf = new BasicFlight(num,width,cap);
		for (int i=0; i<cap;i++)
		{
			in = new Scanner(System.in);
			System.out.println("Please enter the Passenger name: ");
			name = in.nextLine();
			System.out.println("Please enter the Passenger telephone: ");
			telephoneNumber = in.nextLine();
			System.out.println("Please enter the Passenger seat: ");
			Person p = new Person(name,telephoneNumber);
			FirstClassBooking fcb = new FirstClassBooking(p,bf);
			System.out.println(fcb.toString());
			

		}


	}

}
