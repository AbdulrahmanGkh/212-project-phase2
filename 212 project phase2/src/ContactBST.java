
public class ContactBST<T> {
	 NodeBST<T> root;
	 NodeBST<T> current;
    
    /** Creates a new instance of BST */  
    public ContactBST() {  
        root = current = null;  
    }  
      
    public boolean empty() {  
        return root == null;  
    }  
      
    public boolean full() {  
        return false;  
    }  
      
    public Contact_ retrieve () {  
        return current.data;  
    }  
  
    public boolean findkey(String tkey) {  
    	 NodeBST<T> p=root , q=root;;  
          
        if(empty())  
            return false;  
          
        while(p!=null) {  
            q=p;  
            if(p.key.equalsIgnoreCase(tkey)) {  
                current=p;  
                return true;  
            }  
            else if(p.key.compareTo(tkey) < 0)  //check
                p=p.left;  
            else  
                p=p.right;  
        }  
        current=q;  
        return false;  
    }  
    public boolean insert(String name , String phoneNumber,String emailAddress,String address,String birthday,String notes) {  
    	NodeBST<T> p,q=current; 
    	Contact_ c = new Contact_(name,phoneNumber,emailAddress,address,birthday,notes); // this method take a contact to store it in the list
  
        if(findkey(name)) {  // findKey(name,phonenumber)   check this
            current=q;  
            return false;  
        }  
        p=new NodeBST<T>(name,c);  
          
        if(empty()) {  
        	root=current=p;  
        	return true;  
        }	else 	{  
        	if(name.compareTo(current.key) < 0)  
        		current.left=p;  
        	else	  
        		current.right=p;  
        }  
        current=p;  
        return true;  
    } 
    public boolean removeKey() {}
    public NodeBST<T> remove(){}
    public NodeBST<T> findMin(){}
    public NodeBST<T> findRoot(){}
    public void findByFirstName(){}
     public Contact_ searchName() {
    	
    }
    public Contact_ serachPhoneNumber() {
    	
    }
    public void searchAddress() {}
    public void searchEmailAddress() {}
    public void serachBirthday() {}
    public void printByOrder() {} // not sure about this method
    }
