/*
 * Class: CMSC204 
 * Instructor: David Kuijt
 * Description: Postfix/infix notation converter
 * Due: 02/17/2023
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Samson Pak
*/
import exceptions.*;
import java.lang.Math;
public class Notation {
	//Constructor
	public Notation(){
		
	}
	
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException{
		return 0;
		
	}
	
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException{
		MyStack<String> stack = new MyStack<>();
		try {
			for(int i=0; i < postfix.length(); i++) {
				char c = postfix.charAt(i);
				switch(c) {
				case '^':
				case '+':
				case '-':
				case '*':
				case '/':
					String b = stack.pop();
					String a = stack.pop();
					stack.push("(" + a + c + b + ")");
					break;
				default:
					stack.push("" + c);
					break;
				}
			}
			return stack.pop();
		}
		catch(Exception e) {
			throw new InvalidNotationFormatException();
		}
	}
	
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException{
		MyStack<Character> stack = new MyStack<>(infix.length());
		String postfix = "";
		try {
			for(int i = 0; i < infix.length(); i++) {
				char nextChar = infix.charAt(i);
				if(Character.isDigit(nextChar)) {	
					stack.push(nextChar);
					continue;
				}
				switch(nextChar) {
				case '^':
					stack.push(nextChar);
					break;
				case '+':
				case '-':
				case '*':
				case '/':
					while(!stack.isEmpty() && (precedence(nextChar) <= precedence(stack.top()))){
						postfix += stack.pop();
					}
					stack.push(nextChar);
					break;
				case '(':
			         stack.push(nextChar);
			         break;
			    case ')': // Stack is not empty if infix expression is valid 
			         char topOperator = stack.pop(); 
			         while (topOperator != '(')
			         {
			            postfix += topOperator;
			            topOperator = stack.pop();
			         } 
			         break;
			      default: 
			         break; // Ignore unexpected characters
				}
				while (!stack.isEmpty()) 
				{
				   char topOperator = stack.pop();
				   postfix += topOperator;
				} 
				return postfix;
			}
		}
		catch(Exception e) {
			throw new InvalidNotationFormatException();
		}
		return "";
	}
	
	public static int precedence(char value) {
		 switch (value) {
	        case '+':
	        case '-':
	            return 1;
	 
	        case '*':
	        case '/':
	            return 2;
	 
	        case '^':
	            return 3;
	        }
	        return -1;
	}
	
}
