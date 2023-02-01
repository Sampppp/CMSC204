import java.util.regex.*;

import java.util.*;
public class PasswordCheckerUtility {
    
    private static Matcher match;
    private static Pattern upper = Pattern.compile("[A-Z]");
    private static Pattern lower = Pattern.compile("[a-z]");
    private static Pattern digit = Pattern.compile("[0-9]");
    private static Pattern special = Pattern.compile("[!-/:-@]");
    //finish proj idk
    
    public PasswordCheckerUtility(){
    }

    public static void comparePasswords(String password, String passwordConfirm)throws UnmatchedException{
        if(!password.equals(passwordConfirm))
            throw new UnmatchedException();
    }

    public static boolean comparePasswordsWithReturn(String password, String passwordConfirm){
        return (password.equals(passwordConfirm));
    }

    public static boolean isValidLength(String password)throws LengthException{
        if(password.length() < 6)
            throw new LengthException();
        return true;
    }

    public static boolean hasUpperAlpha(String password)throws NoUpperAlphaException{
        match = upper.matcher(password);
        if(!match.find())
            throw new NoUpperAlphaException();
        return true;
    }

    public static boolean hasLowerAlpha(String password)throws NoLowerAlphaException{
        match = lower.matcher(password);
        if(!match.find())
            throw new NoLowerAlphaException();
        return true;
    }
    
    public static boolean hasDigit(String password)throws NoDigitException{
        match = digit.matcher(password);
        if(!match.find())
            throw new NoDigitException();
        return true;
    }

    public static boolean hasSpecialChar(String password)throws NoSpecialCharacterException{
        match = special.matcher(password);
        if(!match.find())
            throw new NoSpecialCharacterException();
        return true;
    }

    public static boolean noSameCharInSequence(String password)throws InvalidSequenceException{
        for(int i = 1; i < password.length() - 1; i++){
            if(password.charAt(i) == password.charAt(i - 1) && password.charAt(i) == password.charAt(i + 1))
                throw new InvalidSequenceException();
        }
        return true;
    }

    public static boolean isValidPassword(String password)throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException{
        if(isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasDigit(password) && hasSpecialChar(password) && noSameCharInSequence(password))
            return true;
        return false;
    }

    public static boolean hasBetweenSixAndNineChars(String password){
        return (password.length() > 5 && password.length() < 10);
    }

    public static boolean isWeakPassword(String password)throws WeakPasswordException{
        	try{
        		isValidLength(password);
        	}
        	catch(Exception e){
        		throw new WeakPasswordException();
        	}
        	if(hasBetweenSixAndNineChars(password))
        		throw new WeakPasswordException();
        	return false;
    }

    public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
    	ArrayList<String> invalidPasswords = new ArrayList<>();//make ArrayList to store invalid passwords
    	for(int i = 0; i < passwords.size(); i++) {
        	try {
        		isValidPassword(passwords.get(i));//checks if password is valid
        	}
        	catch(Exception e) {
        		invalidPasswords.add(String.format("%s %s", passwords.get(i), e.getMessage()));//if invalid it adds the password and thrown message to ArrayList
        	}
        }
        return invalidPasswords;
    }
}
