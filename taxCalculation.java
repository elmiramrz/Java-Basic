//**********************************************
//Workshop #2
//Course:<subject type> - Semester
//Last Name:<Mirza>
//First Name:<Elmira>
//ID:<130828197>
//Section:<NBB>
//This assignment represents my own work in accordance with Seneca Academic Policy.
//Signature
//Date:<15-02-2021>
//**********************************************//
import java.util.Scanner;

public class taxCalculation {
	
	public static void main(String[] args) {
		int choice;
		do {
		Scanner sc = new Scanner(System.in);
		
		IncomeTax inc=new IncomeTax();
		//print choices
		
		System.out.println("1 - Compute personal income Tax");
		System.out.println("2 - Print the tax tables for taxable incomes (with range)");
		System.out.println("3 - Exit\n");
		System.out.print("Enter menu number:");
		
		 choice=sc.nextInt();
		
		if (choice==1)
		{
			personalInc();
		}
		else if (choice==2)
		{//prompt user for the income range
			
			System.out.print("Enter the amount From: $");
			int from=sc.nextInt();
			System.out.print("Enter the amount To: $");
			int fromTo=sc.nextInt();
			System.out.println("\n2001 tax tables for taxable income from $"+from +" to $"+fromTo+"\n");
			//print the header for tax table 
			tableHeader();
			
			int i=from;
			//print table 2001
			do {
				
				System.out.println(i+"            "+String.format("%.2f",tax2001(i,0))+"         "+String.format("%.2f",tax2001(i,1))+"          "+String.format("%.2f",tax2001(i,2))+"           "+String.format("%.2f",tax2001(i,3)));
				i=i+1000;
				
				
			}while (i<=fromTo);
			System.out.println("\n\n2009 tax tables for taxable income from $"+from +" to $"+fromTo+"\n");
			tableHeader();
			i=from;
			
			//print table 2009
do {
	

				
				System.out.println(i+"            "+String.format("%.2f",tax2009(i,0))+"         "+String.format("%.2f",tax2009(i,1))+"          "+String.format("%.2f",tax2009(i,2))+"           "+String.format("%.2f",tax2009(i,3)));
				
				i=i+1000;
				
			}while (i<=fromTo);
		}
System.out.println("\n");
		
		}while (choice !=3);
		
		
}

	//----------------Table Header
	public static void tableHeader()
	{
	System.out.println("----------------------------------------------------------------------------------");
	System.out.println("Taxable          Single         Married Joint        Married          Head of");
	System.out.println("Income                           or Qualifying       Separate         a House");
	System.out.println("                                   Widow(er)");
	System.out.println("----------------------------------------------------------------------------------");
		
	}
	
	//----------------print status
	public static void status()
	{
		System.out.println("0 - single filer");
		System.out.println("1 - married jointly or qualifying widow(er)");
		System.out.println("2 - married separately");
		System.out.println("3 - head of household\n");
		
	}
	//----------------compute personal income tax--choice one
	public static void personalInc() {
		//to print statuses
		status();
		
		Scanner sc = new Scanner(System.in);
		IncomeTax inTax=new IncomeTax();
		//get status from user
		System.out.print("Enter the filing status:");
		inTax.filingStatus=sc.nextInt();
		
		//get income from user
			System.out.print("Enter the Taxable Income: $");
			inTax.taxableIncome=sc.nextDouble();
           
           //for print with two decimal places
            System.out.println("Tax is: $"+String.format("%.2f",tax2009(inTax.taxableIncome,inTax.filingStatus)));
		
	}

		
//-----------------------------------print tax for 2009
	
	public static double tax2009(double income,int status) {
		IncomeTax inTax=new IncomeTax();
		

		    // Compute tax
		    double tax = 0;

		    if (status == 0) { // Compute tax for single filers
		      if (income <= 8350)
		        tax = income * 0.10;
		      else if (income <= 33950)
		        tax = 8350 * 0.10 + (income - 8350) * 0.15;
		      else if (income <= 82250)
		        tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
		          (income - 33950) * 0.25;
		      else if (income <= 171550)
		        tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
		          (82250 - 33950) * 0.25 + (income - 82250) * 0.28;
		      else if (income <= 372950)
		        tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
		          (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 +
		          (income - 171550) * 0.33;
		      else
		        tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
		          (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 +
		          (372950 - 171550) * 0.33 + (income - 372950) * 0.35;
		    }
		    else if (status == 1) { // Compute tax for married file jointly
		      // Left as exercise in Programming Exercise 3.13
		    	if (income <= 16700)
			        tax = income * 0.10;
			      else if (income <= 67900)
			        tax = 16700 * 0.10 + (income - 16700) * 0.15;
			      else if (income <= 137059)
			    	  tax = 16700 * 0.10 + (16700) * 0.15 +
			          (137050 - 67900) * 0.25;
			      else if (income <= 208850)
			    	  tax = 16700 * 0.10 + (16700) * 0.15 +
			          (137050 - 67900) * 0.25 + (208850 - 137050) * 0.28;
			      else if (income <= 372950)
			    	  tax = 16700 * 0.10 + (16700) * 0.15 +
			          (137050 - 67900) * 0.25 + (208850 - 137050) * 0.28 +
			          (372950 - 208850) * 0.33 ;
			      else
			    	  tax = 16700 * 0.10 + (16700) * 0.15 +
			          (137050 - 67900) * 0.25 + (208850 - 137050) * 0.28 +
			          (372950 - 208850) * 0.33 + (income - 372950) * 0.35;
		    }
		    else if (status == 2) { // Compute tax for married separately
		      // Left as exercise in Programming Exercise 3.13
		    	if (income <= 8350)
			        tax = income * 0.10;
			      else if (income <= 33950)
			        tax = 8350 * 0.10 + (income - 8350) * 0.15;
			      else if (income <= 82250)
			        tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
			          (income - 33950) * 0.25;
			      else if (income <= 171550)
			        tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
			          (82250 - 33950) * 0.25 + (income - 82250) * 0.28;
			      else if (income <= 372950)
			        tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
			          (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 +
			          (income - 171550) * 0.33;
			      else
			        tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
			          (68525 - 33950) * 0.25 + (104425 - 68526) * 0.28 +
			          (186475 - 104425) * 0.33 + (income - 186476) * 0.35;
		    }
		    else if (status == 3) { // Compute tax for head of household
		      // Left as exercise in Programming Exercise 3.13
		    	if (income <= 11950)
			        tax = income * 0.10;
			      else if (income <= 45500)
			        tax = 11950 * 0.10 + (income - 11950) * 0.15;
			      else if (income <= 117450)
			    	  tax = 11950 * 0.10 + (11950) * 0.15 +
			          (income - 45500) * 0.25 ;
			      else if (income <= 190200)
			    	  tax = 11950 * 0.10 + (11950) * 0.15 +
			          (117450 - 45500) * 0.25 + (income - 117450) * 0.28 ;
			      else if (income <= 372950)
			    	  tax = 11950 * 0.10 + (11950) * 0.15 +
			          (117450 - 45500) * 0.25 + (190200 - 117450) * 0.28 +
			          (income - 190200) * 0.33 ;
			      else
			    	  tax = 11950 * 0.10 + (11950) * 0.15 +
			          (117450 - 45500) * 0.25 + (190200 - 117450) * 0.28 +
			          (372950 - 190200) * 0.33 + (income - 372950) * 0.35;
		    }
		    else {
		      System.out.println("Error: invalid status");
		      System.exit(1);
		    }
		    return tax;
	}
///////-------------compute tax for 2001
	public static double  tax2001(double income,int status) {
		IncomeTax inTax=new IncomeTax();
		//int status=inTax.getFilingStatus();

		    // Compute tax
		    double tax = 0;
		    if (status == 0) { // Compute tax for single filers
			      if (income <= 27050)
			        tax = income * 0.15;
			      else if (income <= 65550)
			        tax = 27050 * 0.15 + (income - 27050) * 0.275;
			      else if (income <= 136750)
			    	  tax = 27050 * 0.15 + (65550 - 27050) * 0.275 + (income - 65550) * 0.305;
			      else if (income <= 297350)
			    	  tax = 27050 * 0.15 + (65550 - 27050) * 0.275 +
				         + (136750 - 65550) * 0.305 +  (income - 136750) * 0.355 ;
			      else
			    	  tax = 27050 * 0.15 + (65550 - 27050) * 0.275 +
			         + (136750 - 65550) * 0.305 +
			          (297350 - 136750) * 0.355 + (income - 297350) * 0.391;
			    }
			    else if (status == 1) { // Compute tax for married file jointly
			      // Left as exercise in Programming Exercise 3.13
				      if (income <= 45200)
					        tax = income * 0.15;
					      else if (income <= 109250)
					    	  tax = 45200 * 0.15 + (income - 45200) * 0.275;
					      else if (income <= 166500)
					    	  tax = 45200 * 0.15 + (109250 - 45200) * 0.275 +
						         + (income - 109250) * 0.305 ;
					      else if (income <= 297350)
					    	  tax = 45200 * 0.15 + (109250 - 45200) * 0.275 +
						         + (166500 - 109250) * 0.305 +
						          (income - 166500) * 0.355 ;
					      else
					    	  tax = 45200 * 0.15 + (109250 - 45200) * 0.275 +
					         + (166500 - 109250) * 0.305 +
					          (297350 - 166500) * 0.355 + (income - 297350) * 0.391;
			    }
			    else if (status == 2) { // Compute tax for married separately
			      // Left as exercise in Programming Exercise 3.13
				      if (income <= 22600)
					        tax = income * 0.15;
					      else if (income <= 54625)
					    	  tax = 22600 * 0.15 + (income - 22600) * 0.275;
					      else if (income <= 83250)
					    	  tax = 22600 * 0.15 + (54625 - 22600) * 0.275 +
						         + (income - 54625) * 0.305;
					      else if (income <= 148675)
					    	  tax = 22600 * 0.15 + (54625 - 22600) * 0.275 +
						         + (83250 - 54625) * 0.305 +
						          (income - 83250) * 0.355 ;
					      else
					    	  tax = 22600 * 0.15 + (54625 - 22600) * 0.275 +
					         + (83250 - 54625) * 0.305 +
					          (148675 - 83250) * 0.355 + (income - 148675) * 0.391;
			    }
			    else if (status == 3) { // Compute tax for head of household
			      // Left as exercise in Programming Exercise 3.13
				      if (income <= 36250)
					        tax = income * 0.15;
					      else if (income <= 93650)
					    	  tax = 36250 * 0.15 + (income - 36250) * 0.275 ;
					      else if (income <= 151650)
					    	  tax = 36250 * 0.15 + (93650 - 36250) * 0.275 +
						         + (income - 93650) * 0.305 ;
					      else if (income <= 297350)
					    	  tax = 36250 * 0.15 + (93650 - 36250) * 0.275 +
						         + (151650 - 93650) * 0.305 +
						          (income - 151650) * 0.355 ;
					      else
					    	  tax = 36250 * 0.15 + (93650 - 36250) * 0.275 +
					         + (151650 - 93650) * 0.305 +
					          (297350 - 151650) * 0.355 + (income - 297350) * 0.391;
			    }
			    else {
			      System.out.println("Error: invalid status");
			      System.exit(1);
			    }

		    
		    // Display the result
		   // System.out.println("Tax is " + (int)(tax * 100) / 100.0);
	
	return tax;
}
	
//------------------------------------	
}
class IncomeTax{
	final int SINGLE_FILER=0;
	 final int  MARRIED_JOINTLY_OR_QUALIFYING_WIDOW_ER=1;
	 final int MARRIED_SEPARATELY =2;
	 final int HEAD_OF_HOUSEHOLD =3;
	 int[][] intervals;
	 int[]  rates;
	 double taxableIncome;
	 int filingStatus;
	 public IncomeTax() {}
	 
public IncomeTax(int filingStatus , int[][] Intervals ,double[] rates ,double taxableIncome )
{

	filingStatus=filingStatus;
	intervals=Intervals;
	rates=rates;
	taxableIncome=taxableIncome;
}

public int getFilingStatus() {
	return filingStatus;
}
public void setFilingStatus(int status) {
	this.filingStatus=status;
}
public int[][] getIntervals()
{
	return intervals;
}
public void setIntervals(int[][] intervals) {
	this.intervals=intervals;
}
public int[] getRates() {
	return rates;
}
public void setRates(int[] rates) {
	this.rates=rates;
}
public double getTaxableIncome() {
	return taxableIncome;
}
public void setTaxableIncome(double taxableIncome ) {
	this.taxableIncome=taxableIncome;
}
public double getIncomeTax() {

	
	return taxableIncome;
}
}


