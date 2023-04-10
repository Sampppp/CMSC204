
public class TreeNode<T> {

	protected T data;
	protected TreeNode<T> left, right;
	
	//constructors
	//data param
	public TreeNode(T dataNode) {
		data = dataNode;
		left = null;
		right = null;
	}
	//copy
	public TreeNode(TreeNode<T> node) {
		data = node.getData();
		left = node.getLeft();
		right = node.getRight();
	}
	
	//getters
	public T getData() {
		return data;
	}
	
	public TreeNode<T> getLeft(){
		return left;
	}
	
	public TreeNode<T> getRight(){
		return right;
	}
	
	//setters
	public void setLeft(TreeNode<T> a){
		left = a;
	}
	
	public void setRight(TreeNode<T> a){
		right = a;
	}
}
