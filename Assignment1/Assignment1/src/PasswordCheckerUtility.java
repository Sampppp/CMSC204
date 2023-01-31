import jave.util.*;
public class PasswordCheckerUtility {
    private String password;
    private String passwordConfirm;
    private ArrayList<String> passwords = new ArrayList<>();
    
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
        return (password.length() < 6);
    }

    public static boolean hasUpperAlpha(String password)throws NoUpperAlphaException{
        for(int i = 0; i < password.length(); i++){
            if(Character.isUpperCase(password.charAt(i))){
                return true;
            }
        }
        return false;
    }

    public static boolean hasLowerAlpha(String password)throws NoLowerAlphaException{
        for(int i = 0; i < password.length(); i++){
            if(Character.isLowerCase(password.charAt(i))){
                return true;
            }
        }
        return false;
    }
    
    public static boolean hasDigit(String password)throws NoDigitException{
        for(int i = 0; i < password.length; i++){
            if(Character.isDigit(password.charAt(i))){
                return true;
            }
        }
        return false;
    }

    public static boolean hasSpecialChar(String password)throws NoSpecialCharacterException{
        for(int i = 0; i < password.length; i++){
            if(!Character.isLetter(password.charAt(i)) && Character.isDigit(password.charAt(i)))
                return true;   
        }
        return false;
    }

    public static boolean noSameCharInSequence(String password)throws InvalidSequenceException{
        for(int i = 1; i < password.length - 1; i++){
            if(password.charAt(i) == password.charAt(i - 1) && password.charAt(i) == password.charAt(i + 1))
                return false;
        }
        return true;
    }

    public static boolean isValidPassword(String password)throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException{
        return (isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasDigit(password) && hasSpecialChar(password) && noSameCharInSequence(password));
    }

    public static boolean hasBetweenSixAndNineChars(String password){
        return (password.length() > 5 && password.length() < 10);
    }

    public static boolean isWeakPassword(String password)throws WeakPasswordException{
        return (isValidLength(password) && hasBetweenSixAndNineChars(password));
    }

    public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){

    }

}
