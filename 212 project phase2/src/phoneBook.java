import java.util.Scanner;
public class phonebook_ {
	
	
	
	
	public static void ProgramMenu() { 
	System.out.println("Welcome to the Linked Tree Phoonebook!");
	System.out.println("Please choose an option");
	System.out.println("1.Add a contact");
	System.out.println("2.Search for a contact");
	System.out.println("3.Delete a contact");
	System.out.println("4.Sechedule an event");
	System.out.println("5.Print event details");
	System.out.println("6.Print contact by first name");
	System.out.println("7.Print all events alphabetically");
	System.out.println("8.Print Contact that share an event");
	System.out.println("9.Exit");
	System.out.println("Enter your choice: ");
	}
	public static void SearchContactMenu() {
		System.out.println("Enter Search criteria: ");
		System.out.println("Name");
		System.out.println("Phone Number");
		System.out.println("Email Address");
		System.out.println("Address");
		System.out.println("Birthday");
	}
	
	public static void PrintEvent() {
		System.out.println("Enter search criteria");
		System.out.println("1. contact name");
		System.out.println("2. Event tittle");
		System.out.println("Enter your choice");
	}
	
	

	public static void main(String[] args) {
	 Scanner input = new Scanner(System.in);
	 String name="Ibra";
	 String phoneNumber;
	 String emailAddress;
	 String address;
	 String birthday;
	 String notes;
	 String eventTitle;
	 String DateAndtime;
	 String location;
	 String voidd;
	 int choice;
	 ContactBST<Contact_> c = new ContactBST<Contact_>();
	 EventList <Event_> e = new EventList<Event_>();
	 
	// c.insert(name, "4545", "g", "11", "22", "nulll");
	 c.insert("al d", "4", "g", "11", "22", "nulll");
	 c.insert("al b", "46", "g", "11", "22", "nulll");
	 c.insert("al a", "47", "g", "11", "22", "nulll");
	 c.insert("al c", "454", "g", "11", "22", "nulll");
	// c.insert("feras bhsdffjhs", "454", "g", "11", "22", "nulll");
	
	 //c.printInOrder(c.findRoot(c));
	//c.removeKey("feras", e);
	//c.FirstName("al");
	 //c.serachBirthday("22");
	 e.scheduleEvent("dinner", "2", "b", c.searchName("al a"), false, e);
	 e.scheduleEvent("dinner", "2", "b", c.searchName("al d"), false, e);
	 e.scheduleEvent("breakfast", "3", "d", c.searchName("al d"), true, e);
	
	 //e.printAlphabitically();
	
	// e.serachEvent(e, "dinner");
	c.removeKey("al a", e);
	e.serachEvent(e, "dinner");
	e.searchContact(e, "al d");
	 
	
		
		
	}
}
