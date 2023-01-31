import jave.util.*;
public class PasswordCheckerUtility {
    private String password;
    private String passwordConfirm;
    private ArrayList<String> passwords = new ArrayList<String>();
    
    //add 'throws' to methods
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

    public static boolean isValidLength(String password){
        return (password.length() < 6);
    }
    public static boolean hasUpperAlpha(String password){
        for(int i = 0; i < password.length(); i++){
            if(Character.isUpperCase(password.charAt(i))){
                return true;
            }
        }
        return false;
    }

    public static boolean hasLowerAlpha(String password){
        for(int i = 0; i < password.length(); i++){
            if(Character.isLowerCase(password.charAt(i))){
                return true;
            }
        }
        return false;
    }
    
    public static boolean hasDigit(String password){
        for(int i = 0; i < password.length; i++){
            if(Character.isDigit(password.charAt(i))){
                return true;
            }
        }
        return false;
    }

    public static boolean hasSpecialChar(String password){
        for(int i = 0; i < password.length; i++){
            if(!Character.isLetter(password.charAt(i)) && Character.isDigit(password.charAt(i)))
                return true;   
        }
        return false;
    }

    public static boolean NoSameCharInSequence(String password){
        for(int i = 1; i < password.length - 1; i++){
            if(password.charAt(i) == password.charAt(i - 1) && password.charAt(i) == password.charAt(i + 1))
                return false;
        }
        return true;
    }

    public static boolean isValidPassword(String password){
        
    }

    public static boolean hasBetweenSixAndNineChars(String password){
        return (password.length() > 5 && password.length() < 10);
    }

    public static boolean isWeakPassword(String password){
        return (isValidLength(password) && hasBetweenSixAndNineChars(password));
    }

    public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
        
    }

}
