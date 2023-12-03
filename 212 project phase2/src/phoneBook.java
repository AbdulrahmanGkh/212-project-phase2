
import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class phonebook_ {
	private static int getSafeIntegerInput(Scanner scanner) {
	    final String ANSI_RED = "\u001B[31m";
	    final String ANSI_RESET = "\u001B[0m";

	    while (true) {
	        try {
	            return Integer.parseInt(scanner.nextLine());
	        } catch (NumberFormatException e) {
	            System.out.println(ANSI_RED + "Invalid input. Please enter a number!" + ANSI_RESET);
	            System.out.println("\r");
	            ProgramMenu();
	        }
	    }
	}

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
	System.out.println("8.Exit");
	System.out.println("Enter your choice: ");
	}
	public static void SearchContactMenu() {
		System.out.println("Enter Search criteria: ");
		System.out.println("1.Name");
		System.out.println("2.Phone Number");
		System.out.println("3.Email Address");
		System.out.println("4.Address");
		System.out.println("5.Birthday");
	}
	
	public static void PrintEvent() {
		System.out.println("Enter search criteria");
		System.out.println("1. contact name");
		System.out.println("2. Event tittle");
		System.out.println("Enter your choice");
	}
	
	

	public static void main(String[] args) {
	 Scanner input = new Scanner(System.in);
	 String name;
	 String phoneNumber;
	 String emailAddress;
	 String address;
	 String birthday;
	 String notes;
	 String eventTitle;
	 Date date;
	 String time;
	 String location;
	 String voidd;
	 int choice;
	 ContactBST<Contact_> c = new ContactBST<Contact_>();
	 EventList <Event_> e = new EventList<Event_>();
	 SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm"); // Define the date format
	 
	 do {
		 ProgramMenu(); //this calls the menu we created above
		 
		choice = getSafeIntegerInput(input);
		switch (choice){
		
		case 1:
			
			System.out.print("Enter the contact's name:");
			 name=input.nextLine();
			System.out.print("Enter the contact's phone number:");
			 phoneNumber=input.nextLine();
			System.out.print("Enter the contact's email address:");
			 emailAddress=input.nextLine();
			System.out.print("Enter the contact's address:");
			 address=input.nextLine();
			System.out.print("Enter the contact's birthday:");
			 birthday=input.nextLine();
			System.out.print("Enter any notes for the contact:");
			 notes=input.nextLine();
			if(c.searchName(name)!=null || c.serachPhoneNumber(c.findRoot(c),phoneNumber) !=null) { 
				System.out.println("Contact is found...can not add contact that has the same name or number");
				System.out.println("\r");
				break;
			}
			else {
				c.insert(name, phoneNumber, emailAddress, address, birthday, notes);
				System.out.println(" Contact added successfully! ");
				System.out.println("\r");
				break;
			}
			
		case 2:
			
			SearchContactMenu();
			int choice2;
			choice2=getSafeIntegerInput(input);
			switch(choice2) {
			case 1:
				
				System.out.print("Enter the contact's name:");
				name=input.nextLine();
				Contact_ contact1 = c.searchName(name);
				if(contact1!=null) {
					System.out.println("Name:" +contact1.getName());
					System.out.println("Phone Number:" +contact1.getPhoneNumber());
					System.out.println("Email Address:" +contact1.getEmailAddress());
					System.out.println("Address:" +contact1.getAddress());
					System.out.println("Birthday:" +contact1.getBirthday());
					System.out.println("Notes:" + contact1.getNotes());
					System.out.println("\r");
					break;
				}
				else {
				System.out.println("There is no contacts with the same name");
				System.out.println("\r");
				 break;
				}
			case 2:
				
				System.out.print("Enter Phone number:");
				phoneNumber=input.nextLine();
				Contact_ contact2 = c.serachPhoneNumber(c.findRoot(c),phoneNumber);
				if(contact2!=null) {
					System.out.println("Name:" +contact2.getName());
					System.out.println("Phone Number:" +contact2.getPhoneNumber());
					System.out.println("Email Address:" +contact2.getEmailAddress());
					System.out.println("Address:" +contact2.getAddress());
					System.out.println("Birthday:" +contact2.getBirthday());
					System.out.println("Notes:" + contact2.getNotes());
					System.out.println("\r");
					break;
				}
				System.out.println("There is no contacts with the same phone number");
				System.out.println("\r");
				break;
			case 3:
				
				System.out.print("Enter Email Address");
				emailAddress=input.nextLine();
				c.searchEmail(emailAddress);
				System.out.println("\r");
				break;
			case 4:
				
				System.out.print("Enter Address");
				address=input.nextLine();
				c.searchAddress(address);
				System.out.println("\r");
				break;
			case 5:
			
				System.out.print("Enter birthday");
				birthday=input.nextLine();
				c.serachBirthday(birthday);
				System.out.println("\r");
				break;
			}
			System.out.println("\r");
			break;
			
		case 3: 
		
		System.out.print("Enter contact name that you want to delete");
		name=input.nextLine();
		if(c.searchName(name)!=null) {
			c.removeKey(name,e);
			System.out.println("Contact deleted");
			}
		else 
			System.out.println("There is no contact to delete");
		System.out.println("\r");
		break;
	
		case 4:
			
			System.out.println("Enter type:");
			System.out.println("1.event ");
			System.out.println("2.appointment");
			System.out.println("NOTE event is for 2 or more contacts!!!!");
			int choice3=getSafeIntegerInput(input);
			switch(choice3) {
			case 1:
				
			    System.out.print("Enter event title:");
			    eventTitle = input.nextLine();
			    System.out.print("Enter names of contacts in this event (comma-separated, must be two or more):");
			     name = input.nextLine();
			    String[] contactNames = name.split(","); // Split input by commas and optional whitespaces

			    if (contactNames.length < 1) {
			        System.out.println("Error: At least two contacts are required for an event.");
			        break;
			    }
			    System.out.println("Enter event date and time (MM/DD/YYYY HH:MM):");
			    try {
	                date = formatter.parse(input.nextLine()); // Parse the date and time input
	            } catch (ParseException e2) {
	                System.out.println("Invalid date format. Please enter date and time in MM/DD/YYYY HH:MM format.");
	                break;
	            }
			    time= formatter.format(date); // Convert the Date object back to String if needed
			    System.out.print("Enter event location:");
			    location = input.nextLine();
			    

			    // Loop through the contactNames array and add each contact to the event
			    for (String contactName : contactNames) {
			    	if(c.searchName(contactName)!=null && !e.Conflict(c.searchName(contactName), time)) {
			    		e.scheduleEvent(eventTitle, time, location, c.searchName(contactName), false, e);
			    	 	System.out.println("Event added successfully!");
			    	}
			    	
			    	else if (c.searchName(contactName)==null) 
			    		System.out.println("There is no contact with the same name to add an event ");
			    		
			    	
			    	else 
			    		System.out.println("There is a conflict");
			    		
			    }
			   
			    System.out.println("\r");
			    break;

				
			case 2:
			
				System.out.print("Enter appointment");
				eventTitle=input.nextLine();
				System.out.print("Enter contact in this appointment:");
				name=input.nextLine();
				System.out.println("Enter event date and time (MM/DD/YYYY HH:MM):");
			    try {
	                date = formatter.parse(input.nextLine()); // Parse the date and time input
	            } catch (ParseException e1) {
	                System.out.println("Invalid date format. Please enter date and time in MM/DD/YYYY HH:MM format.");
	                break;
	            }
			    time= formatter.format(date); // Convert the Date object back to String if needed
				System.out.print("Enter event location:");
				location=input.nextLine();
				
				if(c.searchName(name)!=null && !e.Conflict(c.searchName(name), time)) {
				e.scheduleEvent(eventTitle, time, location,  c.searchName(name), true, e);
				System.out.println("Appointment added successfully!");
				}
				else if(c.searchName(name)==null) 
					System.out.println("There is no contact with the same name to add an appointment");
				else
					System.out.println("There is a conflict");
					
			}
			System.out.println("\r");
			break;
				
			
		case 5:
			
			PrintEvent();
			
			int choice4=getSafeIntegerInput(input);
			
			if(choice4==1) {
				
				System.out.print("Enter contact name:");
				 name=input.nextLine();
				 if(c.searchName(name)!=null) {
					 e.searchContact(e, name);
					System.out.println("\r");
					break;
					 }
				 else
					 System.out.println("There is no contact with the same name");
			}
			
			else if(choice4==2) {
				
				System.out.print("Enter the event title");
				eventTitle=input.nextLine();
				e.serachEvent(e,eventTitle);
				System.out.println("\r");
				break;
			}
			else
				System.out.println("Wrong input");
			System.out.println("\r");
			break;
			
		case 6:
			
			System.out.print("Enter the first name:");
			name=input.nextLine();
			c.FirstName(name);
			System.out.println("\r");
			break;
			
		case 7:
			e.printAlphabitically();
			System.out.println("\r");
			break;
			
		case 8:
			System.out.println("Exiting the program. Goodbye!");
			System.out.println("\r");
			break;
			default: 
				System.out.println("Invaled choice,please try to Enter number from 1-9");
				System.out.println("\r");
		}
		
	}while(choice !=8 );
	 }
}
