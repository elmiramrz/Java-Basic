
/**********************************************
Workshop #1
Course:JAC444 - Winter2021
Last Name:Elmira 
First Name:Mirza
ID:130828197
Section:NBB
This assignment represents my own work in accordance with Seneca Academic Policy. Signature
Date:<submission date>
**********************************************/
import java.util.Scanner;

public class MaxLocation {

	public static void main(String[] args) {
		// Create a Scanner
Scanner userArray = new Scanner(System.in);
		
//Prompt the user to enter a two-dimensional array 
		System.out.print("Enter the number of rows and columns in the array:");

		
		int Row=userArray.nextInt();

		int Column=userArray.nextInt();
		System.out.print("\n\n");
		 
		double[][] TaskOne=new double[Row][Column];


		System.out.println("Enter the array:");
		for(int i=0; i<TaskOne.length;i++)
		{            
		   for(int j=0; j<TaskOne[i].length;j++)
		   {
		   	TaskOne[i][j]=userArray.nextDouble();
		   }
		}
		// Get the location of the largest element

		double[] location = MaxMember(TaskOne);
		// Display results
System.out.println("The location of the largest element is "+(int)location[2]+" at "+"("+(int)location[0]+","+(int)location[1]+")");

		
		}
	/** MaxMember returns the location of the 
    largest element in a two-dimensional array*/
	 public static double[] MaxMember(double[][] sample) {
		 double[] l = new double[3];
			l[0] = 0;
			l[1] = 0;
			l[2] = 0;
			double max = 0;
			for (int i = 0; i < sample.length; i++) {
				for (int j = 0; j < sample[i].length; j++) {
					if (sample[i][j] > max) {
						l[0] = i;
						l[1] = j;
						max = sample[i][j];
					}
				}
				l[2]=(int)max;
			}

	        return l;
	    }

	}
	
