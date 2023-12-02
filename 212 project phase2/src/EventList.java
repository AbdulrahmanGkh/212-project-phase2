
public class EventList<T>  {
	public NodeList<T> head;
	public NodeList<T> current;
	
	public EventList(){
		head=current=null;
	}
	
	//setters and getters
	public boolean isEmpty() {
		return head==null;
	}
		
	public boolean full() {
		return false;
		}
	
	public boolean last() {
		return current.next == null;
		}
		
	public void findFirst() {
		current=head;
		}
		
	public void findNext() {
		current=current.next;
		}
		
	public Event_ retrive() {
		return current.data;
		}
		
	public void ubdate(Event_ val) {
		current.data=val;
		}
	
	
	public void removeEvent(String contact) {
		if(isEmpty())
			return;
		current=head;
		
		NodeList<T> prev = head;
		NodeList<T> curr = head.next;
		while( curr!=null) {
			curr.data.listContact.removeContactFromList(contact);
			if( curr.data.listContact.isEmpty())
				prev.next =  curr.next;	
			prev =  curr;
			curr =  curr.next;
		}
		current.data.listContact.removeContactFromList(contact);
		
		if (current.data.listContact.isEmpty()) 
			head = head.next;

	}
	
	public void scheduleEvent(String title, String dateandtime, String location, Contact_ contact,Boolean appointment,EventList<Event_> e) {
		
		if (isEmpty()) {
			Event_ x = new Event_(title, dateandtime, location,appointment);
			x.listContact.insertContactInList(contact);
			current = head =new NodeList<T>(x);
			return;
		}
		e.findFirst();
		if(appointment);
		else {
			while(current!=null) {
				if(current.data.getEventTitle().equalsIgnoreCase(title)&&current.data.isAppointment()==false) {
					current.data.listContact.insertContactInList(contact);
				return;
					}
				current=current.next;
				}
			}
		Event_ x = new Event_(title, dateandtime, location,appointment);
		x.listContact.insertContactInList(contact);
		e.findFirst();
		if (x.compareTo(head.data) < 0) { // the name is first alphabetically
			NodeList<T> tmp = head;
			head = new NodeList<T>(x);
			head.next = tmp;
		} else {
			while (current.next != null && x.compareTo(current.next.data) > 0)
				current = current.next; // the name goes to its alphabetical place
			NodeList<T> tmp = current.next;
			current.next = new NodeList<T>(x);
			current = current.next;
			current.next = tmp;

		}

		
	}
	public void insertContactInList(Contact_ val) {
		
		NodeList<T> tmp;
		if (isEmpty()) {
			current = head = new NodeList<T> (val);
		}
		else {
			tmp = current.next;
			current.next = new NodeList<T> (val);
			current = current.next;
			current.next = tmp;
		}

		
	}
	
	public void removeContactFromList(String contact) {
		
		current = head;
		// Case 1: Remove the head node
		
		// Case 2: Remove a node other than the head
		NodeList<T> prev = head;
		NodeList<T> curr = head.next;

		while (curr != null) {
			if (curr.Data.getName().equalsIgnoreCase(contact)) {
				prev.next = curr.next;
			}
			prev = curr;
			curr = curr.next;
		}
		if (head.Data.getName().equalsIgnoreCase(contact)) 
			head = head.next;
	}
	
	public boolean searchNameInList(Contact_ contact) {
		// if he find the name return true
		findFirst();
			if (isEmpty())
				return false;
			while (!last()) {
				if (current.Data.equals(contact)) // if he find the name
					return true;
					findNext();
			}
			if (current.Data.equals(contact)) // if the name in the last
				return true;

		return false;
	}
	
	public void printContactInList(EventList<T> e) {
		current=head;
		while(current!=null) {
			System.out.println("Contact name: "+e.current.Data.getName());
			current=current.next;
			}
		
	}
	
	public boolean Conflict(Contact_ contact, String time) {
		current = head;
		while (current != null) {
			if (current.data.getDateAndTime().equalsIgnoreCase(time) ) 
				if(current.data.listContact.searchNameInList(contact))
					return true; // check if contact have conflict or not
			current = current.next;
			}
		return false;
	}

	public void searchContact(EventList<T> e, String name) {
		current=head;	
		while(current!=null) {
			if(current.data.isAppointment()){
				if(current.data.listContact.head.Data.getName().equalsIgnoreCase(name))
					System.out.println("Event Title: "+current.data.getEventTitle()+"\nContact name: "+current.data.listContact.head.Data.getName()+"\nEvent date and time (MM/DD/YYYY HH:MM) "+current.data.getDateAndTime()+"\nEvent location: "+current.data.getLocation());
				}
			else 
			{
				NodeList<Contact_> tmp=current.data.listContact.head;//the list for contact names
				while(tmp!=null) {
					if(tmp.Data.getName().equalsIgnoreCase(name)) {
						System.out.println("Event Title: "+current.data.getEventTitle());
						current.data.listContact.printContactInList(current.data.listContact);
						System.out.println("Event date and time (MM/DD/YYYY HH:MM) "+current.data.getDateAndTime()+"\nEvent location: "+current.data.getLocation());
							}
					tmp=tmp.next;
				}
		
			}	
		current=current.next;
		}

	}
	public void serachEvent(EventList<T> e , String title) {
		current=head;
		while(current!=null) {
			if(e.current.data.getEventTitle().equalsIgnoreCase(title)) {
				System.out.println("Event Title: "+current.data.getEventTitle());
				current.data.listContact.printContactInList(current.data.listContact);
				System.out.println("Event date and time (MM/DD/YYYY HH:MM) "+current.data.getDateAndTime()+"\nEvent location: "+current.data.getLocation());
			}
		current=current.next;
		}
	}

	public void printAlphabitically() {
		if (this.isEmpty()) {
			System.out.println("The linked list is empty.");
			return;
		}
		current = head;
		while (current != null) {
		    System.out.println("Title: " + current.data.getEventTitle());
			current = current.next;
		}	
	}
}
	

