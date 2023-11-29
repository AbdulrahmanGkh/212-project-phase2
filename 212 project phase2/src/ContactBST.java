
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
    public void searchAddress(String address) {
    	SearchAddress_rec(root, address);
    }
    private void SearchAddress_rec (NodeBST<T> p , String address) {
    	 if (p == null)  
             return ;  
         else if (((Contact_)p.data).compareToAddress(address) == 0)  
             System.out.println(p.data);  
           
         SearchAddress_rec(p.left , address);  
         SearchAddress_rec(p.right, address);  
    }
    public void searchEmail(String email) {
    	SearchEmail_rec(root,email);
    }
    private void SearchEmail_rec(NodeBST<T> p , String email) {
    	if (p == null)  
            return;  
          
        else if (((Contact_)p.data).compareToEmail(email) == 0)  
            System.out.println(p.data);  
          
        SearchEmail_rec(p.left , email);  
        SearchEmail_rec(p.right, email);  
    }
    public void serachBirthday(String birthday) {
    	SearchBirthday_rec(root, birthday);
    }
    private void SearchBirthday_rec(NodeBST<T> p , String birthday) {
    	 if (p == null)  
             return ;  
         else    if (((Contact_)p.data).compareToBirthday(birthday) == 0)  
             System.out.println(p.data);  
           
         SearchBirthday_rec(p.left , birthday);  
         SearchBirthday_rec(p.right, birthday);  
    	
    }
    public void printByOrder() {} // not sure about this method
    }
