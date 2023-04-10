/*
 * Class: CMSC204 
 * Instructor: David Kuijt
 * Description: Morse code converter with file import
 * Due: 04/09/2023
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Samson Pak
*/

import java.io.File;
import java.io.FileNotFoundException;
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
		return print.substring(0, print.length() - 1);
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
	
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		Scanner in = new Scanner(codeFile);
		String result = convertToEnglish(in.nextLine());
		in.close();
		
		return result;
	}
	
	
	
	
	
	
}
