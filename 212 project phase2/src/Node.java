
public class NodeList<T> {
	public Event_ data;
	public Contact_ Data;
	public NodeList<T> next;
	
	public NodeList() {
		data=null;
		Data=null;
	}
	public NodeList(Event_ e) {
		data=e;
		next=null;
	}
	public NodeList(Contact_ c) {
		Data=c;
		next=null;
	}
}
