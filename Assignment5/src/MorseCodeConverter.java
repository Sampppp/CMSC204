import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
	private static MorseCodeTree tree = new MorseCodeTree();
	//constructor
	public MorseCodeConverter() {
	}
	
	public static String printTree(){
		ArrayList<String> temp = tree.toArrayList();
		String print = "";
		for(int i = 0; i < temp.size(); i++) {
			print += temp.get(i) + " ";
		}
		return print.substring(0, print.length() - 2);
	}
	
	
	public static String convertToEnglish(String code) {
		String[] temp = code.split(" ");
		String result = "";
		for(int i = 0; i < temp.length; i++) {
			if(temp[i].compareTo("/") == 0) 
				result += " ";
			else
				result += tree.fetch(temp[i]);
		}
		return result;
	}
	
	public static String convertToEnglish(File codeFile) throws java.io.FileNotFoundException {
		Scanner in = new Scanner(codeFile);
		String result = convertToEnglish(in.nextLine());
		in.close();
		
		return result;
	}
	
	
	
	
	
	
}
