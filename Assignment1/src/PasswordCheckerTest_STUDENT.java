
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * STUDENT tests for the methods of PasswordChecker.
 *
 * @author 
 */
public class PasswordCheckerTest_STUDENT {
	
	/** The passwords. */
	ArrayList<String> passwords = new ArrayList<>();
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		passwords = new ArrayList<>();
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			PasswordCheckerUtility.isValidPassword("a");
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a LengthExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides LengthException. Threw: " + e.getMessage(),false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case.
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			PasswordCheckerUtility.isValidPassword("abcd1234!@");
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException. Threw: " + e.getMessage(),false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case.
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			PasswordCheckerUtility.isValidPassword("ABCD1234!@");
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException. Threw: " + e.getMessage(),false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case.
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			PasswordCheckerUtility.isWeakPassword("abCD12!");
		}
		catch(WeakPasswordException e)
		{
			assertTrue("Successfully threw a WeakPasswordException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides WeakPasswordException. Threw: " + e.getMessage(),false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case.
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			PasswordCheckerUtility.isValidPassword("AAAbc12!@");
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw a InvalidSequenceException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides InvalidSequenceException. Threw: " + e.getMessage(),false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException.
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try{
			PasswordCheckerUtility.isValidPassword("AAAbcde!@");
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw a NoDigitException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoDigitException. Threw: " + e.getMessage(),false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception.
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try{
			PasswordCheckerUtility.isValidPassword("ABCdef123!");
			assertTrue("Password successful",true);
		}
		catch(Exception e)
		{
			assertTrue("Password invalid. Threw: " + e.getMessage(),false);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method.
	 */
	@Test
	public void testInvalidPasswords() {
		passwords.add("ABCdef123!");
		passwords.add("a");
		passwords.add("abcd1234!@");
		passwords.add("ABCD1234!@");
		
		ArrayList<String> results = new ArrayList<>(PasswordCheckerUtility.getInvalidPasswords(passwords));
		
		assertEquals(results.size(), 3);
		assertEquals(results.get(0), "a The password must be at least 6 characters long");
		assertEquals(results.get(1), "abcd1234!@ The password must contain at least one uppercase alphabetic character");
		assertEquals(results.get(2), "ABCD1234!@ The password must contain at least one lowercase alphabetic character");
	}
	
}
