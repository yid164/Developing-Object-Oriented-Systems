// Name: Yinsheng Dong
// NSID: yid164
// Student Number: 11148648
// Lecture Section: CMPT 270 




import java.util.Scanner;
/** the Person class will have a name and a telephone number*/
public class Person {                 
	/** The String name field to store a name string*/
	private String name;   
	/** The tlephoneNumber string to store a telephone Number*/
	private String telephoneNumber; 
	/**The in Scanner to store every input */
	private static Scanner in;        
	
	
	/** the constructor with 2 parameter for the person's name and telephone number*/
	public Person (String n, String t)
	{
		name = n;
		telephoneNumber = t;
	}
	
	/**The getName method is an accessor to return the person's name*/
	public String getName ()
	{
		
		return name;
	}
	
	/**The getTelephoneNumber is an accessor to return the telephone Number for this person*/
	public String getTelephoneNumber ()
	{
		return telephoneNumber;
	}
	
	/**The setTelephoneNumber method is an mutator to change the person's telephone number*/
	public void setTelephoneNumber (String telephoneNumber)
	{
		this.telephoneNumber = telephoneNumber;
		
	}
	
	/**The method to return a string that print the person's name and phone number*/
	public String toString ()
	{
		String a ="Name: "+getName()+" Telephone number: "+getTelephoneNumber();
		return a;
	}

	public static void main(String[] args) {
		System.out.println("Please enter the name: ");
		in = new Scanner(System.in);
		String n = in.nextLine();
		System.out.println("Please enter the phone number: ");
		in = new Scanner(System.in);
		String t = in.nextLine();
		Person p1 = new Person(n,t);
		System.out.println(p1.toString());
		/**To ask user if they would like to change phone number for testing the setTelephoneNumber method*/
		System.out.println("Need change phone number? y/n");
		in = new Scanner(System.in);
		String a = in.nextLine();
		if (a.equals("y")||a.equals("Y"))
		{
			/**if they choose yes, the will be asked to input a new phone number*/
			System.out.println("Please enter the new phone number:");
			in = new Scanner(System.in);
			String t1 = in.nextLine();
			p1.setTelephoneNumber(t1);
			System.out.println(p1.toString());

		}
		else
		{
			/**print the end info*/
			System.out.println("GOOD!");
		}
		
		in.close();
	}

}
