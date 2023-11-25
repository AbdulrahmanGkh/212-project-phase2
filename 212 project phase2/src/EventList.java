
public class EventList<T> {
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
	
	public boolean searchNameInList() {}
	public boolean Conflict() {}
	public void scheduleEvent() {}
	public void insertContactInList() {}
	public void printAlphabitically() {}
	public void removeContactFromList() {}
	public void searchContact() {}
	public void printContactInList() {}
	public void serachEvent() {}
	
}
