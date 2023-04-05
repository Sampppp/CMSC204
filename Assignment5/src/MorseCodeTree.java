import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	TreeNode<String> root;
	
	//constructor
	MorseCodeTree(){
		buildTree();
	}
	//copy constructor
	MorseCodeTree(MorseCodeTree a){
		root = new TreeNode<>(a.root);
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
			addNode(temp, code.substring(1), letter);
			break;
		case '-':
			root.setRight(temp);
			addNode(temp, code.substring(1), letter);
			break;
		}
	}

	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}

	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		if(code.length() == 1) {
			switch(code.charAt(0)){
			case '.':
				return root.getLeft().getData();
			case '-':
				return root.getRight().getData();
			}
		}
			
		switch(code.charAt(0)){
		case '.':
			return fetchNode(root.getLeft(), code.substring(1));
		case '-':
			return fetchNode(root.getRight(), code.substring(1));
		}
		return null;
	}

	@Override
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		MorseCodeTree temp = new MorseCodeTree(this);
		root = null;
		return temp;
	}

	@Override
	public MorseCodeTree update() throws UnsupportedOperationException {
		return this;
	}

	@Override
	public void buildTree() {
		root = new TreeNode<>("");
		
		insert(".", "e");
		insert("-", "t");
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		insert("", "s");
		insert("", "u");
		insert("", "r");
		insert("", "w");
		insert("", "d");
		insert("", "k");
		insert("", "g");
		insert("", "o");
		insert("", "h");
		insert("", "v");
		insert("", "f");
		insert("", "l");
		insert("", "p");
		insert("", "j");
		insert("", "b");
		insert("", "x");
		insert("", "c");
		insert("", "y");
		insert("", "z");
		insert("", "q");
	}

	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> list = new ArrayList<>();
		LNRoutputTraversal(root, list);
		return list;
	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root == null)
			return;
		
		LNRoutputTraversal(root.getLeft(), list);
		list.add(root.getData());
		LNRoutputTraversal(root.getRight(), list);
	}







	



	
}
