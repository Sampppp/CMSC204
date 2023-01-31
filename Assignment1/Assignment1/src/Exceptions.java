public class LengthException extends Exception{
    public LengthException(){
        super("The password must be at least 6 characters long");
    }
}
public class NoUpperAlphaException extends Exception{
    NoUpperAlphaException(){
        super("The password must contain at least one uppercase alphabetic character");
    }
}

public class NoLowerAlphaException extends Exception{
    NoLowerAlphaException(){
        super("The password must contain at least one lowercase alphabetic character");
    }
}

public class NoDigitException extends Exception{
    NoDigitException(){
        super("The password must contain at least one digit");
    }
}

public class NoSpecialCharacterException extends Exception{
    NoSpecialCharacterException(){
        super("The password must contain at least one special character");
    }
}

public class InvalidSequenceException extends Exception{
    InvalidSequenceException(){
        super("The password cannot contain more than two of the same character in sequence");
    }
}

public class WeakPasswordException extends Exception{
    WeakPasswordException(){
        super("The password is OK but weak - it contains fewer than 10 characters");
    }
}

public class UnmatchedException extends Exception{
    UnmatchedException(){
        super("The passwords do not match");
    }
}