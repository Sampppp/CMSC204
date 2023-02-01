/*
 * Class: CMSC204 
 * Instructor: David Kuijt
 * Description: Password checker that checks passwords
 * Due: 02/01/2023
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Samson Pak
*/
import java.util.regex.*;

import java.util.*;
// TODO: Auto-generated Javadoc

/**
 * The Class PasswordCheckerUtility.
 */
public class PasswordCheckerUtility {
    
    /** The match. */
    private static Matcher match;
    
    /** The upper. */
    private static Pattern upper = Pattern.compile("[A-Z]");//patterns for password requirements
    
    /** The lower. */
    private static Pattern lower = Pattern.compile("[a-z]");
    
    /** The digit. */
    private static Pattern digit = Pattern.compile("[0-9]");
    
    /** The special. */
    private static Pattern special = Pattern.compile("[!-/:-@]");
    
    /**
     * Instantiates a new password checker utility.
     */
    public PasswordCheckerUtility(){//constructer
    }

    /**
     * Compare passwords.
     *
     * @param password the password
     * @param passwordConfirm the password confirm
     * @throws UnmatchedException the unmatched exception
     */
    public static void comparePasswords(String password, String passwordConfirm)throws UnmatchedException{//compares passwords
        if(!password.equals(passwordConfirm))
            throw new UnmatchedException();
    }

    /**
     * Compare passwords with return.
     *
     * @param password the password
     * @param passwordConfirm the password confirm
     * @return true, if successful
     */
    public static boolean comparePasswordsWithReturn(String password, String passwordConfirm){
        return (password.equals(passwordConfirm));
    }

    /**
     * Checks if is valid length.
     *
     * @param password the password
     * @return true, if is valid length
     * @throws LengthException the length exception
     */
    public static boolean isValidLength(String password)throws LengthException{//checks if length is less than 6 chars
        if(password.length() < 6)
            throw new LengthException();
        return true;
    }

    /**
     * Checks for upper alpha.
     *
     * @param password the password
     * @return true, if successful
     * @throws NoUpperAlphaException the no upper alpha exception
     */
    public static boolean hasUpperAlpha(String password)throws NoUpperAlphaException{//checks for uppercase
        match = upper.matcher(password);
        if(!match.find())
            throw new NoUpperAlphaException();
        return true;
    }

    /**
     * Checks for lower alpha.
     *
     * @param password the password
     * @return true, if successful
     * @throws NoLowerAlphaException the no lower alpha exception
     */
    public static boolean hasLowerAlpha(String password)throws NoLowerAlphaException{//checks for lowercase
        match = lower.matcher(password);
        if(!match.find())
            throw new NoLowerAlphaException();
        return true;
    }
    
    /**
     * Checks for digit.
     *
     * @param password the password
     * @return true, if successful
     * @throws NoDigitException the no digit exception
     */
    public static boolean hasDigit(String password)throws NoDigitException{//checks for digits
        match = digit.matcher(password);
        if(!match.find())
            throw new NoDigitException();
        return true;
    }

    /**
     * Checks for special char.
     *
     * @param password the password
     * @return true, if successful
     * @throws NoSpecialCharacterException the no special character exception
     */
    public static boolean hasSpecialChar(String password)throws NoSpecialCharacterException{//checks for special chars
        match = special.matcher(password);
        if(!match.find())
            throw new NoSpecialCharacterException();
        return true;
    }

    /**
     * No same char in sequence.
     *
     * @param password the password
     * @return true, if successful
     * @throws InvalidSequenceException the invalid sequence exception
     */
    public static boolean noSameCharInSequence(String password)throws InvalidSequenceException{//checks for repeated sequence chars
        for(int i = 1; i < password.length() - 1; i++){
            if(password.charAt(i) == password.charAt(i - 1) && password.charAt(i) == password.charAt(i + 1))
                throw new InvalidSequenceException();
        }
        return true;
    }

    /**
     * Checks if is valid password.
     *
     * @param password the password
     * @return true, if is valid password
     * @throws LengthException the length exception
     * @throws NoUpperAlphaException the no upper alpha exception
     * @throws NoLowerAlphaException the no lower alpha exception
     * @throws NoDigitException the no digit exception
     * @throws NoSpecialCharacterException the no special character exception
     * @throws InvalidSequenceException the invalid sequence exception
     */
    public static boolean isValidPassword(String password)throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException{//checks if password passes all rerquirements
        if(isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasDigit(password) && hasSpecialChar(password) && noSameCharInSequence(password))
            return true;
        return false;
    }

    /**
     * Checks for between six and nine chars.
     *
     * @param password the password
     * @return true, if successful
     */
    public static boolean hasBetweenSixAndNineChars(String password){//checks if password is between 6 and 9 chars in length
        return (password.length() > 5 && password.length() < 10);
    }

    /**
     * Checks if is weak password.
     *
     * @param password the password
     * @return true, if is weak password
     * @throws WeakPasswordException the weak password exception
     */
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

    /**
     * Gets the invalid passwords.
     *
     * @param passwords the passwords
     * @return the invalid passwords
     */
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
