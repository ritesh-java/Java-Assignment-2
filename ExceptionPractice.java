package packageone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionPractice{
	
	public static void main(String[] args) throws IOException{
	    BigInteger num = null;
	    String str="";
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    System.out.println("Please choose the valid type of card (VISA, MASTERCARD, MAESTRO): ");
	    try{
	    	str = br.readLine();
	    	str = str.toUpperCase();
	    	if(!(str.equals("VISA") || str.equals("MASTERCARD") || str.equals("MAESTRO"))){
	    			throw new InvalidCardException("Invalid card type. Please choose the right option!!");	
	    	}
	    }catch(Exception e){
	      System.out.println(e);
	      System.exit(0);
	    }
	    
		System.out.println("Enter 16 digit card number");
		Scanner scan = new Scanner(System.in);
		
		try{
			num = scan.nextBigInteger();
			
			if(num.toString().length()<16 || num==null){
				throw new InvalidCardException("Invalid card number exception. Please enter 16 digit card number!!");
			}
			
		}catch(InputMismatchException ie){
			System.out.println("Please enter numbers only!!");
			System.exit(0);
		}
		catch(Exception e){
			System.out.println(e);
			System.exit(0);
		}
		System.out.println("Thanks for making payment!! Please verify your card information!!");
		System.out.println("Card type: "+str+" and card number is "+num);
	}
}


class InvalidCardException extends Exception{
	String str1;
	
	public InvalidCardException(String str1) {
	this.str1 = str1;
	}	
	
	public String toString(){
		return str1;
		
	}
}