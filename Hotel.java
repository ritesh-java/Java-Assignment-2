package packageone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Hotel{
	public static int numdest;
	public static void main(String[] args) throws IOException{
		System.out.println("Enter the number of destinations for which you want different hotel information");
		Scanner s = new Scanner(System.in);
		
		if(s.hasNextInt())
		 numdest = s.nextInt();
		else{
			System.out.println("Please enter the integeral value only!!!!");
		    System.exit(0);
		}
		
		Destination d = new Destination(numdest);
		String[] destination = new String[numdest];
		String[][] hotels = new String[numdest][3];
		String[][] expense = new String[numdest][3];
		String[][] days = new String[numdest][3];
		
		for(int i =0;i<numdest;i++){
			System.out.println("Enter the name of destination number "+(i+1)+" :");
			destination[i] = s.next();
	            for(int x = 0; x<3;x++){
    			System.out.println("Enter the name of hotel "+(x+1));
    			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
                hotels[i][x]=br.readLine();
           
                System.out.println("Enter the price of hotel "+hotels[i][x]);
                expense[i][x] = s.next();
                
                System.out.println("Enter the number of days you can stay in "+hotels[i][x]);
                days[i][x] = s.next();
               
            }

		}
		
		 Destination d2 = new Destination(destination, hotels, expense, days);
         System.out.println(d2.toString());
         System.out.println("Please choose one destination from above");
		 String userDest =  s.next();
		 String desList[] = new String[numdest];
		 desList = d2.getDestination();
		 Boolean setFlag = false;

		 for(int x = 0;x<desList.length;x++){
			 if(desList[x].equals(userDest)){
				 System.out.println("Please find the best hotel package plans in "+desList[x]+" below:");
				 d2.bestPlans(x); 
				 setFlag = true;
				 break;
			 }
		 }
		 
		 if(!setFlag)
			 System.out.println("The place entered is not in our database. We apologise for an inconvenience!!!!");
		 
		
	}
}


class Destination{
	private String[] destination;
	private String[][] hotels;
	private String[][] expense;
	private String[][] days;
	private int index;
	
	public Destination() {
		// TODO Auto-generated constructor stub
	}
	
	public Destination(int i){
		this.destination = new String[i];
		this.hotels = new String[i][3];
		this.expense = new String[i][3];
		this.days = new String[i][3];
	}
	
	public Destination(String[] des, String[][] hotel, String[][] exp, String[][] day){
		destination = des;
		hotels = hotel;
		expense = exp;
		days = day;
	}

	public String[] getDestination() {
		return destination;
	}

	public void setDestination(String[] destination) {
		this.destination = destination;
	}

	public String[][] getHotels() {
		return hotels;
	}

	public void setHotels(String[][] hotels) {
		this.hotels = hotels;
	}

	public String[][] getExpense() {
		return expense;
	}

	public void setExpense(String[][] expense) {
		this.expense = expense;
	}

	public String[][] getDays() {
		return days;
	}

	public void setDays(String[][] days) {
		this.days = days;
	}

	@Override
	public String toString() {
		return "Destination [destination=" + Arrays.toString(destination) + "]";
	}
	
	public void bestPlans(int index){
		this.index=index;
		for(int i =0;i<3;i++){
			System.out.println("Hotel "+hotels[this.index][i]+" offers a stay of "+days[this.index][i]+" days for Rs "+expense[this.index][i]+" only!!");
		}
	}
	
}