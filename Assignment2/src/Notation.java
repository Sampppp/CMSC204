/*
 * Class: CMSC204 
 * Instructor: David Kuijt
 * Description: Postfix/infix notation converter
 * Due: 02/24/2023
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
		MyStack<Double> stack = new MyStack<>();
		char nextChar;
		try {
			for(int i = 0; i < postfixExpr.length(); i++) {
				nextChar = postfixExpr.charAt(i);
				if(Character.isDigit(nextChar)) {	
					stack.push((double) (nextChar - 48));
					continue;
				}
				double b = stack.pop();
				double a = stack.pop();
				switch(nextChar) {
					case '^':
						stack.push(Math.pow(b, a));
						break;
					case '+':
						stack.push(a + b);
						break;
					case '-':
						stack.push(a - b);
						break;
					case '*':
						stack.push(a * b);
						break;
					case '/':
						stack.push(a / b);
						break;
					default:
						break;
				}
			}
			return stack.top();
		}
		catch(Exception e) {
			throw new InvalidNotationFormatException();
		}
	}
	
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException{
		MyStack<String> stack = new MyStack<>();
		try {
			for(int i = 0; i < postfix.length(); i++) {
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
		char topOperator;
		
		try {
			for(int i = 0; i < infix.length(); i++) {
				char nextChar = infix.charAt(i);
				if(Character.isDigit(nextChar)) {	
					postfix += nextChar;
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
							postfix += stack.top();
							stack.pop();
						}
						stack.push(nextChar);
						break;
					case '(':
				         stack.push(nextChar);
				         break;
				    case ')':
				         topOperator = stack.pop(); 
				         while (topOperator != '(')
				         {
				            postfix += topOperator;
				            topOperator = stack.pop();
				         } 
				         break;
				    default: 
				         break;
				}
			}
			while (!stack.isEmpty()) 
			{
			   topOperator = stack.pop();
			   postfix += topOperator;
			} 
			return postfix;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new InvalidNotationFormatException();
		}
	}
	
	private static int precedence(char value) {
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
