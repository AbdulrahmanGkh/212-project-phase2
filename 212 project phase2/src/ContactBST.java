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
  /*  public boolean insert(String name , String phoneNumber,String emailAddress,String address,String birthday,String notes) {  
    	NodeBST<T> p,q=current; 
    	Contact_ c = new Contact_(name,phoneNumber,emailAddress,address,birthday,notes); // this method take a contact to store it in the list
  
        if(findkey(name)) {  // findKey(name,phonenumber)   check this
            current=q;
            return false;  
        }  
        p=new NodeBST<T>(name,c);  
          
        if(empty()) {  
        	root=current=p; 
        	System.out.println("Added succefully");
        	return true;  
        }	else 	{  
        	if(name.compareTo(current.key) < 0)  
        		current.left=p;  
        	else	  
        		current.right=p;  
        }  
        current=p; 
        System.out.println("Added succefully");
        return true;  
    } */
    
    public boolean insert(String name, String phoneNumber, String emailAddress, String address, String birthday, String notes) {
        Contact_ c = new Contact_(name, phoneNumber, emailAddress, address, birthday, notes);
        NodeBST<T> newNode = new NodeBST<T>(name, c);
        // Check if the BST is currently empty
        if (empty()) {
            root = newNode;
            return true;
        }
     // Initialize parent and current pointers for traversing the tree
        NodeBST<T> parent = null;
        NodeBST<T> current = root;

       
        while (current != null) {
            parent = current;
            if (name.compareTo(current.key) < 0) // Compare the new contact's name with the current node's key
                current = current.left;  // If name is smaller, move to the left subtree
            else if (name.compareTo(current.key) > 0)  // If name is greater, move to the right subtree
                current = current.right;
             else 
                return false; // If a duplicate key is found, return false as insertion is not allowed
        }
        if (name.compareTo(parent.key) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

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
    public void printInOrder(NodeBST<T>root ) {
    	
    	if (root != null) {
            // Traverse the left subtree
            printInOrder(root.left);

            // Print the current node's value
            System.out.println(root.data.getName() + " ");

            // Traverse the right subtree
            printInOrder(root.right);
        }

    	
    } 

    public void FirstName( String name) {
        boolean exist = searchFirstName(root, name);
        if (!exist)
            System.out.println("There is no contact with the same first name");
    }

    private boolean searchFirstName(NodeBST<T> node, String name) {
        if (node == null)
            return false;

        String nodeName = node.getData().getName();
        String first[] = nodeName.split(" ");

        boolean found = false;

        if (first[0].equals(name)) {
            // Found a contact with the same first name
            System.out.println("Contacts found!");
            System.out.println("Name: " + node.getData().getName());
            System.out.println("Phone Number: " + node.getData().getPhoneNumber());
            System.out.println("Email Address: " + node.getData().getEmailAddress());
            System.out.println("Address: " + node.getData().getAddress());
            System.out.println("Birthday: " + node.getData().getBirthday());
            found = true;
        }

        // Continue searching in both subtrees
        found = searchFirstName(node.getLeft(), name) || found;
        found = searchFirstName(node.getRight(), name) || found;

        return found;
    }

 }
