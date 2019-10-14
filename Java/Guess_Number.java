import java.util.Scanner;
import java.lang.Math;
public class Guess_Number{
	public static void main(String[] args){
		int num = (int)(Math.random()*101);
		System.out.println("Guess a number between 0 to 100");
		Scanner input = new Scanner(System.in);
		int guess = -1;
		while(guess!=num){
		System.out.print("\nEnter you guess:");
				guess = input.nextInt();
				if (guess == number){
				System.out.println("Yes,the number is"+num);
				}else if(guess >number){
				System.out.println("your guess is too high ");
				}else{
					System.out.println("Your guess is too low ");
				}
				
		}
		
	}
}