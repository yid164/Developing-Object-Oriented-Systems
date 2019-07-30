// Name: Yinsheng Dong
// NSID: yid164
// Student Number: 11148648
// Lecture Section: CMPT 270 




import java.util.Scanner;
public class Person {
	
	String name;
	String telephoneNumber;
	private static Scanner in;
	private static Scanner in1;
	private static Scanner in2;
	private static Scanner in3;
	
	
	public Person (String n, String t)
	{
		name = n;
		telephoneNumber = t;
	}
	
	public String getName ()
	{
		
		return "The Passenger's name: " +name +'\n';
	}
	
	public String getTelephoneNumber ()
	{
		return "The Passenger's phone number: " +telephoneNumber +'\n';
	}
	
	public void setTelephoneNumber (String telephoneNumber)
	{
		this.telephoneNumber = telephoneNumber;
		
	}
	
	public String toString ()
	{
		String a =getName()+getTelephoneNumber();
		return a;
	}

	public static void main(String[] args) {
		System.out.println("Please enter the name: ");
		in = new Scanner(System.in);
		String n = in.nextLine();
		System.out.println("Please enter the phone number: ");
		in1 = new Scanner(System.in);
		String t = in1.nextLine();
		Person p1 = new Person(n,t);
		System.out.println("The passenger info: \n"+p1.toString());
		System.out.println("Need change phone number? y/n");
		in2 = new Scanner(System.in);
		String a = in2.nextLine();
		if (a !="n")
		{
			System.out.println("Please enter the new phone number:");
			in3 = new Scanner(System.in);
			String t1 = in3.nextLine();
			p1.setTelephoneNumber(t1);
			System.out.println(p1.toString());

		}
		else
		{
			System.out.println("good");
		}

		
		
	}

}
