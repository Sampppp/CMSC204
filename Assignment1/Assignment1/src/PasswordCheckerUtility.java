import java.lang.WeakPairMap.Pair.Weak;

import javax.lang.model.util.ElementScanner14;

import jave.util.*;
public class PasswordCheckerUtility {
    private static ArrayList<String> passwords = new ArrayList<>();
    
    private static Matcher match;
    private static Pattern upper = Pattern.compile("[A-Z]");
    private static Pattern lower = Pattern.compile("[a-z]");
    private static Pattern digit = Pattern.compile("[0-9]");
    private static Pattern special = Pattern.compile("[!-/:-@]");
    //finish proj idk
    
    public PasswordChecherUtility(){
    }

    public static void comparePassowrds(String password, String passwordConfirm)throws UnmatchedException{
        if(!password.equals(passwordConfirm))
            throw UnmatchedException;
    }

    public static boolean comparePassowrdsWithReturn(String password, String passwordConfirm){
        return (password.equals(passwordConfirm));
    }

    public static boolean isValidLength(String password)throws LengthException{
        if(password.length() < 6)
            throw LengthException;
        return true;
    }

    public static boolean hasUpperAlpha(String password)throws NoUpperAlphaException{
        match = upper.matcher(password);
        if(!match.matches())
            throw NoUpperAlphaException;
        return true;
    }

    public static boolean hasLowerAlpha(String password)throws NoLowerAlphaException{
        match = lower.matcher(password);
        if(!match.matches())
            throw NoLowerAlphaException;
        return true;
    }
    
    public static boolean hasDigit(String password)throws NoDigitException{
        match = digit.matcher(password);
        if(!match.matches())
            throw NoDigitException;
        return true;
    }

    public static boolean hasSpecialChar(String password)throws NoSpecialCharacterException{
        match = special.matcher(password);
        if(!match.matches())
            throw NoSpecialCharacterException;
        return true;
    }

    public static boolean noSameCharInSequence(String password)throws InvalidSequenceException{
        for(int i = 1; i < password.length - 1; i++){
            if(password.charAt(i) == password.charAt(i - 1) && password.charAt(i) == password.charAt(i + 1))
                throw InvalidSequenceException;
        }
        return true;
    }

    public static boolean isValidPassword(String password)throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException{
        if(isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasDigit(password) && hasSpecialChar(password) && noSameCharInSequence(password))
            return true;
        else{
            passwords.add(password);
            return false;
        }
    }

    public static boolean hasBetweenSixAndNineChars(String password){
        return (password.length() > 5 && password.length() < 10);
    }

    public static boolean isWeakPassword(String password)throws WeakPasswordException{
        if(isValidLength(password) && hasBetweenSixAndNineChars(password))
            throw WeakPasswordException;
        return true;
    }

    public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
        return passwords;
    }
}
