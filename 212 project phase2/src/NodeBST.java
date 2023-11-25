
public class NodeBST<T> {
	
	public String key;  
	public Contact_ data;  
    public NodeBST<T> left,right;  
  
    //node without left right  
    public NodeBST(String k,Contact_ val) {  
        key=k;  
        data=val;  
        left=right=null;  
    }  
  
    //node with left right  
  
    public NodeBST(String k,Contact_ val, NodeBST<T> l, NodeBST<T> r) {  
        key=k;  
        data=val;  
        left=l;  
        right=r;  
    }  
    
    public String getKey() {
		return key;
	}

	public Contact_ getData() {
		return data;
	}

	public NodeBST<T> getLeft() {
		return left;
	}

	public NodeBST<T> getRight() {
		return right;
	}
	
}
