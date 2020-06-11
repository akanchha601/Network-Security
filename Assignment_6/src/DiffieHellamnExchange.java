import java.util.Random;
import java.util.Scanner;

public class DiffieHellamnExchange {
	public static void diffieHellamn(double p, double q)
	{
	
		Random random = new Random();
        int  n01 = random.nextInt(8) + 1;
        //randomly generates the secret numbers SA and SB
		System.out.println("SA= "+n01);
		int  n02 = random.nextInt(8) + 1;
		//randomly generates the secret numbers SA and SB
		System.out.println("SB= "+n02);
		// Computes TA
		double TA= (Math.pow(q, n01))%(p);
		System.out.println("TA= "+TA);
		// Computes TB
		double TB= (Math.pow(q, n02))%(p);
		System.out.println("TB= "+TB);
		// They exchange their T's
		System.out.println("after exchanging...");
		double TA1=(Math.pow(TB, n01))%(p);
		System.out.println("TA'="+TA1);
		
		double TB1=(Math.pow(TA, n02))%(p);
		System.out.println("TB'="+TB1);
		// If it arrive same, its a secret key
		if(TA1==TB1) {
			System.out.println("The Diffie Hellman secret key is "+TA1);
		}
		
	}

	public static void main(String[] args) {
	    
		char option = 0;
	    while(true) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Enter p value: "); 
        int p = input.nextInt();
        System.out.println("Enter g value: "); 
        int q = input.nextInt();
        diffieHellamn(p,q);
        System.out.println("Do you want to continue:(Y/N)");
        option=input.next().charAt(0);
        if(option=='Y'||option=='y') {
        	continue;
        }
        else
        	System.out.println("********************You are terminated from the program*******************");
        	System.exit(0);
            
      }
	}   
        
}

