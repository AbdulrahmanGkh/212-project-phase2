
public class Contact_ implements Comparable<Contact_>{
	
	public String name;
	public String phoneNumber;
	public String emailAddress;
	public String address;
	public String birthday;
	public String notes;
	
	

	public Contact_() {
		this.name ="";
		this.phoneNumber = "";
		this.emailAddress = "";
		this.address = "";
		this.birthday = "";
		this.notes = "";	
		}

	public Contact_(String name,String phoneNumber,String emailAddress,String address,String birthday,String notes) {
		this.name = name;
		this.phoneNumber=phoneNumber;
		this.address = address;
		this.birthday = birthday;
		this.notes = notes;
		this.emailAddress=emailAddress;
	}
	public int compareTo(Contact_ other) { //s1.compareTo(s2) if s1 > s2, it returns positive number,if s1 < s2, it returns negative number, if s1 == s2, it returns 0
        return this.name.compareToIgnoreCase(other.name);
	}
	
	 
	

	
	public int compareToEmail(String otherEmail)throws NullPointerException {//bigO(n) this method compare two strings
		 return(this.emailAddress.compareTo(otherEmail));// 
	}
	 public int compareToAddress(String otheraddress) {  
	         
	            return (this.address.compareToIgnoreCase(otheraddress));  
	        }  
	 public int compareToBirthday(String otherbirthday) {  
	            return (this.birthday.compareTo(birthday) ) ;  
	        }  
	
	//setters and getters
	public String getName(){
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	
}
