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
    public boolean removeKey(String key, EventList<Event_> e) {
    	
    	Boolean removed = false;
    	NodeBST<T> p;
		p = remove(key, root, removed);
		current = root = p;
		e.removeEvent(key);
		
		return removed;

    	
    }
    public NodeBST<T> remove(String key , NodeBST<T> p, boolean flag){
    	
    	NodeBST<T> q, child = null;
		if(p == null)
			return null;
		if(key.compareTo(p.key) < 0)
			p.left = remove(key, p.left, flag); //go left
		else if(key.compareTo(p.key) > 0)
			p.right = remove(key, p.right, flag); //go right
		else { // key is found
			flag= true;
			if (p.left != null && p.right != null){ //two children
				q = findMin(p.right);
				p.key = q.key;
				p.data = q.data;
				p.right = remove(q.key, p.right, flag);
			}
			else {
				if (p.right == null) //one child
					child = p.left;
				else if (p.left == null) //one child
					child = p.right;
				return child;
			}
		}
		return p;
    	
    }
    public NodeBST<T> findMin( NodeBST<T> p){
    		if(p == null)
    			return null;
    		
    		while(p.left != null){
    			p = p.left;
    		}
    		
    		return p;
    }
    public NodeBST<T> findRoot(ContactBST<T> B){
    	
    	NodeBST<T> p = B.root;
		return p;
    }
  
    public Contact_ searchName(String key) {
    	
    	NodeBST<T> p = root,q = root;
		
		if(empty())
			return null;
		
		while(p != null) {
			q = p;
			if(p.key.equalsIgnoreCase(key)) {
				current = p;
				return current.data;
			}
			else if(key.compareTo(p.key) < 0 )
				p = p.left;
			else
				p = p.right;
		}
		
		current = q;
		return null;

    	
    }
    public Contact_ serachPhoneNumber(NodeBST<T> root,String phoneNumber) {
    	
  	  // Base case: if the node is null, value not found
        if (root == null) {
            return null;
        }

        // Check if the current node's value is equal to x
        if (root.data.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
            return root.data; // Value found, stop recursion
        }

        // Recursively search in the left subtree
        Contact_ leftResult = serachPhoneNumber(root.left, phoneNumber);
        if (leftResult!=null) {
            return leftResult; // Value found in the left subtree, stop recursion
        }

        // Recursively search in the right subtree
        return serachPhoneNumber(root.right, phoneNumber);

    	
    }
    
    public void searchAddress(String address) {
    	SearchAddress_rec(root, address);
    }
    private void SearchAddress_rec (NodeBST<T> p , String address) {
    	 if (p == null)  
             return  ;  
         else if (((Contact_)p.data).compareToAddress(address) == 0)  {
         System.out.println("Contact found!");
         System.out.println("Name:" +p.data.getName());
    	 System.out.println("Phone Number: " + p.data.getPhoneNumber());
    	 System.out.println("Email Address: "+p.data.getEmailAddress());
    	 System.out.println("Address: "+p.data.getAddress());
    	 System.out.println("Birthday"+p.data.getBirthday());
    	 System.out.println("Notes: " +p.data.getNotes());
         }
         SearchAddress_rec(p.left , address);  
         SearchAddress_rec(p.right, address);  
    }
    public void searchEmail(String email) {
    	SearchEmail_rec(root,email);
    }
    private void SearchEmail_rec(NodeBST<T> p , String email) {
    	if (p == null)  
            return;  

        else if (((Contact_)p.data).compareToEmail(email) == 0) {
         System.out.println("Contact found!");
         System.out.println("Name:" +p.data.getName());
       	 System.out.println("Phone Number: " + p.data.getPhoneNumber());
       	 System.out.println("Email Address: "+p.data.getEmailAddress());
       	 System.out.println("Address: "+p.data.getAddress());
       	 System.out.println("Birthday"+p.data.getBirthday());
       	 System.out.println("Notes: " +p.data.getNotes());
            }  

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
         {
             System.out.println("Contact found!");
             System.out.println("Name:" +p.data.getName());
           	 System.out.println("Phone Number: " + p.data.getPhoneNumber());
           	 System.out.println("Email Address: "+p.data.getEmailAddress());
           	 System.out.println("Address: "+p.data.getAddress());
           	 System.out.println("Birthday"+p.data.getBirthday());
           	 System.out.println("Notes: " +p.data.getNotes());
                } 

         SearchBirthday_rec(p.left , birthday);  
         SearchBirthday_rec(p.right, birthday);  

    }
    public void printByOrder() {} // not sure about this method
    private void searchFirstNameRec(NodeBST<T> root, String name) {
        if (root != null) {
            if (root.data.getName().split(" ")[0].equals(name)) {
                // Display contact details
            }
            
            // Continue searching in both left and right subtrees
            searchFirstNameRec(root.left, name);
            searchFirstNameRec(root.right, name);
        }
    }
    public void searchFirstName(String name) {
        searchFirstNameRec(root, name);
    }
    public void findByFirstName(){}
    }
