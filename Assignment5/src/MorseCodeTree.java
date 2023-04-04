import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	TreeNode<String> tree;
	TreeNode<String> root;
	
	//constructor
	MorseCodeTree(){
		buildTree();
	}
	
	
	
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}

	@Override
	public void insert(String code, String letter) {
		addNode(root, code, letter);
	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		TreeNode<String> temp = new TreeNode<String>(letter);
		//code length 1
		if(code.length() == 1) {
			switch(code.charAt(0)){
				case '.':
					root.setLeft(temp);
					return;
				case '-':
					root.setRight(temp);
					return;
			}
		}
		//code length > 1 
		switch(code.charAt(0)){
		case '.':
			root.setLeft(temp);
			addNode(temp, code.substring(1), letter + ".");
			break;
		case '-':
			root.setRight(temp);
			addNode(temp, code.substring(1), letter + "-");
			break;
		}
	}

	@Override
	public String fetch(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buildTree() {
		tree = new TreeNode<>("");
		root = tree;
	}

	@Override
	public ArrayList<String> toArrayList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		
	}







	



	
}
