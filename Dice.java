

import java.util.Random;
public class Dice {

	public static void main(String[] args) {
		//store the summation in the local variable for 
		int[] result = overall();
		int sum=result[2];
		if (sum==2 || sum==3 || sum==12)
		{
			System.out.println("Craps, Better Luck Next Time, You lose\n");	
		}
		else if(sum==7 || sum==11) 
		{
			System.out.println("Congratulations, You win\n");
		}
		else
		{
			System.out.println("Point is (established) set to "+sum);
			int[] afterEstab ;
			do {
				 afterEstab = overall();
				
			}while(afterEstab[2]!=7 && afterEstab[2]!=sum);
			//compare the first sum with the sum, after establishing point
			if (afterEstab[2]==7)
			{
				System.out.println("Craps, Better Luck Next Time, You lose\n");	
			}
			else if (afterEstab[2]==sum) {
				System.out.println("Congratulations, You win\n");
			}
		}
	}
	/**
	 * produce two random number between 1 and 6 and store 
	 * them with their summation in the array
	 */
	public static int[] overall()
	{
    int[] num = new int[3];
    num[0] = 0;
    num[1] = 0;
    num[2] = 0;
	Random rand = new Random();
    num[0] = rand.nextInt(6)+1;
    Random rand1 = new Random();
    num[1] = rand1.nextInt(6)+1;
	num[2]=num[0]+num[1];
	
	System.out.println(" You rolled "+num[0] +"+"+ num[1] +"="+num[2]);
		return num;
	}

}
